package uk.ac.ebi.ddi.ws.util.user;

import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chris on 16-5-11.
 */
public class UserRepositoryImpl implements UserRepository<User> {

    @Resource
    MongoTemplate mongoTemplate;

    @Override
    public List<User> getAllObject() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public void saveObject(User object) {
        mongoTemplate.insert(object);
    }

    @Override
    public User getObject(String userId) {
        return mongoTemplate.findOne(new Query(Criteria.where("userId").is(userId)), User.class);
    }

    @Override
    public WriteResult updateAccessToken(String userId, String accessToken) {
        return mongoTemplate.updateFirst(new Query(Criteria.where("userId").is(userId)), Update.update("accessToken", accessToken), User.class);
    }

    @Override
    public void deleteObject(String userId) {
        mongoTemplate.remove(new Query(Criteria.where("userId").is(userId)), User.class);
    }

    @Override
    public boolean checkUser(String userId, String accessToken) {
        System.out.println(mongoTemplate.findOne(new Query(Criteria.where("userId").is(userId)), User.class));
        if(mongoTemplate.findOne(new Query(Criteria.where("userId").is(userId)), User.class).getAccessToken().equals(accessToken)) {
            return true;
        }
        return false;
    }

    @Override
    public void insertKeyWorld(String userId, String query) {
        mongoTemplate.updateFirst(new Query(Criteria.where("userId").is(userId)), Update.update("keyWord", query), User.class);
    }
}
