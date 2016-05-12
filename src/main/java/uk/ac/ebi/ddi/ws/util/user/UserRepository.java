package uk.ac.ebi.ddi.ws.util.user;

import com.mongodb.WriteResult;

import java.util.List;

/**
 * Created by chris on 16-5-11.
 */
public interface UserRepository<T> {
    List<T> getAllObject();
    void saveObject(T object);
    T getObject(String userId);

    WriteResult updateAccessToken(String userId, String accessToken);

    void deleteObject(String userId);

    boolean checkUser(String userId, String accessToken);

    void insertKeyWorld(String userId, String query);


//    void createConnection();
//    void dropConnection();
}
