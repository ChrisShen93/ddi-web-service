package uk.ac.ebi.ddi.ws.util.userLog;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

/**
 * Created by chris on 16-5-20.
 */
@Document
public class Log {
    @Id
    private String userId;

    private List<Map> records;

    public Log() {
    }

    public Log(String userId, List<Map> records) {
        this.userId = userId;
        this.records = records;
    }

    public List<Map> getRecords() {
        return records;
    }

    public void setRecords(List<Map> records) {
        this.records = records;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
