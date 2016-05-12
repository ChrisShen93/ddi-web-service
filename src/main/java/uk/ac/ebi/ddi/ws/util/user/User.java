package uk.ac.ebi.ddi.ws.util.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by chris on 16-5-11.
 */

@Document
public class User {
    @Id
    private String userId;
    private String accessToken;
    private String userName;

    public User() {
    }

    public User(String userId, String accessToken, String userName) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", accessToken=" + accessToken +
                '}';
    }
}
