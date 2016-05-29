package uk.ac.ebi.ddi.ws.util.specificSearch;

import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chris on 16-5-27.
 */
public class RecordRepositoryImpl implements RecordRepository<Record> {

    @Resource
    MongoTemplate mongoTemplate;

    @Override
    public List<Record> getAllObject() {
        return mongoTemplate.findAll(Record.class);
    }

    @Override
    public void saveObject(Record object) {
        mongoTemplate.insert(object);
    }

    @Override
    public Record getObject(String userId) {
        return mongoTemplate.findOne(new Query(Criteria.where("userId").is(userId)), Record.class);
    }

    @Override
    public WriteResult updateRecord(String userId, List records) {
        return mongoTemplate.updateFirst(new Query(Criteria.where("userId").is(userId)), Update.update("records", records), Record.class);
    }
}
