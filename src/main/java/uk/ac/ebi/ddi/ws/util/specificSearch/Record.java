package uk.ac.ebi.ddi.ws.util.specificSearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

/**
 * Created by chris on 16-5-27.
 */

@Document(collection = "specificSearchRecords")
public class Record {
    @Id
    private String userId;
    private Map<String, String> records;

    public Record() {
    }

    public Record(String userId, Map<String, String> records) {
        this.userId = userId;
        this.records = records;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, String> getRecords() {
        return records;
    }

    public void setRecords(Map records) {
        this.records = records;
    }
}
