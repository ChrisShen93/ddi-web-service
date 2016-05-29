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
    private List<Map> records;

    public Record() {
    }

    public Record(String userId, List<Map> records) {
        this.userId = userId;
        this.records = records;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Map> getRecords() {
        return records;
    }

    public void setRecords(List<Map> records) {
        this.records = records;
    }
}
