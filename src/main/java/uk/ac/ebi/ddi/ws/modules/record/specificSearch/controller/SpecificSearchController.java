package uk.ac.ebi.ddi.ws.modules.record.specificSearch.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uk.ac.ebi.ddi.ws.util.specificSearch.Record;
import uk.ac.ebi.ddi.ws.util.specificSearch.RecordRepository;
import uk.ac.ebi.ddi.ws.util.user.UserRepository;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by chris on 16-5-27.
 */
@Controller
@RequestMapping(value = "/user")
public class SpecificSearchController {

    @Resource
    UserRepository userRepository;

    @Resource
    RecordRepository recordRepository;

    @RequestMapping(value = "/specificSearch", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody void specificSearchRecord(
            @RequestParam(value = "userId", required = true) String userId,
            @RequestParam(value = "accessToken", required = true) String accessToken,
            @RequestParam(value = "keywords", required = true) String keywords
    ) {

        System.out.println("this is specificSearchController");
//        List<Map> records = new ArrayList<>();
        Map<String, String> records = new HashMap<>();

        records.put("date", Long.toString(new Date().getTime()));
        records.put("keywords", keywords);
//        records.add(record);

        if(userRepository.checkUser(userId, accessToken)) {
            System.out.println("checked userid and accesstoken");
            if(recordRepository.getObject(userId) != null && !"".equals(recordRepository.getObject(userId))) {
                System.out.println("updateRecord");
//            List<Map> preRecords = ((Record)recordRepository.getObject(userId)).getRecords();
//            records.addAll(preRecords);
                recordRepository.updateRecord(userId, records);
            } else {
                System.out.println("savaObject");
                recordRepository.saveObject(new Record(userId, records));
            }
        }
    }

}
