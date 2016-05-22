package uk.ac.ebi.ddi.ws.util.userLog;

import com.mongodb.WriteResult;

import java.util.List;

/**
 * Created by chris on 16-5-20.
 */
public interface LogRepository<T> {
    List<T> getAllObject();
    void saveObject(T object);
    T getObject(String userId);

    void deleteObject(String userId);

    WriteResult updateRecords(String userId, List records);
}
