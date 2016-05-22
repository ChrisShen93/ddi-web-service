package uk.ac.ebi.ddi.ws.util.userLog;

import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chris on 16-5-20.
 */
public class LogRepositoryImpl implements LogRepository<Log> {

    @Resource
    MongoTemplate mongoTemplate;

    @Override
    public List<Log> getAllObject() {
        return mongoTemplate.findAll(Log.class);
    }

    @Override
    public WriteResult updateRecords(String userId, List records) {
        return mongoTemplate.updateFirst(new Query(Criteria.where("userId").is(userId)), Update.update("records", records), Log.class);
    }

    @Override
    public void saveObject(Log object) {
        mongoTemplate.insert(object);
    }

    @Override
    public Log getObject(String userId) {
        return mongoTemplate.findOne(new Query(Criteria.where("userId").is(userId)), Log.class);
    }

    @Override
    public void deleteObject(String userId) {
        mongoTemplate.remove(new Query(Criteria.where("userId").is(userId)), Log.class);
    }
}
