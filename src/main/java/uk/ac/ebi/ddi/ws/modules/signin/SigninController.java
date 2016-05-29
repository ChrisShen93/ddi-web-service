package uk.ac.ebi.ddi.ws.modules.signin;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import uk.ac.ebi.ddi.ws.util.user.User;
import uk.ac.ebi.ddi.ws.util.user.UserRepository;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by chris on 16-5-7.
 */

@Controller
@RequestMapping("/signin")
public class SigninController {

    @Resource
    UserRepository userRepository;

    public String getAccessToken(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }

        String str = json.toString();
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(str, JsonObject.class);
        String accsee_token = jsonObject.get("access_token").getAsString();

        return accsee_token;
    }

    public JsonObject getProfile(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        System.out.println("getProfile:" + json.toString());

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json.toString(), JsonObject.class);
        return jsonObject;
    }

    @RequestMapping(value = "/github")
    public @ResponseBody String test() {
        System.out.println("signin/github");
        return "111";
    }

    @RequestMapping(value = "/getCode", produces = "application/json; charset=utf-8")
    public @ResponseBody String getCode(@RequestParam String code) {
        System.out.println(code);

        Environment evn = null;

        StringBuffer bufferRes = new StringBuffer();

        String getATurl = "https://graph.facebook.com/v2.3/oauth/access_token?client_id=1139710409407100&redirect_uri=http://localhost:8000/Tools/omicsdi&client_secret=f8a0b714aa8ef1fe3b873d83a34426ce&code=" + code;
        String access_token = getAccessToken(getATurl);

        String profileUrl = evn.getProperty("oauth.facebook.graph.baseUrl") + evn.getProperty("oauth.facebook.graph.profile") + access_token;
//        String profileUrl = "https://graph.facebook.com/me?access_token=" + access_token;
        JsonObject profile = getProfile(profileUrl);
        profile.addProperty("access_token", access_token);

        String userName = profile.get("name").getAsString();
        String userId = profile.get("id").getAsString();

        if(userRepository.getObject(userId) != null) {
            userRepository.updateAccessToken(userId, access_token);
        } else {
            userRepository.saveObject(new User(userId, access_token, userName));
        }

        return profile.toString();
    }
}
