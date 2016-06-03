package uk.ac.ebi.ddi.ws.util.specificSearch;

import com.mongodb.WriteResult;

import java.util.List;
import java.util.Map;

/**
 * Created by chris on 16-5-27.
 */
public interface RecordRepository<T> {
    List<T> getAllObject();

    void saveObject(T object);

    T getObject(String userId);

    WriteResult updateRecord(String userId, Map<String, String> records);
}
