package edu.aiub.cs.geonames.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.aiub.cs.geonames.model.Data;
import edu.aiub.cs.geonames.model.base.Location;
import edu.aiub.cs.geonames.model.base.Region;
import edu.aiub.cs.geonames.repository.LocationRepository;
import edu.aiub.cs.geonames.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by Farhan on 9/18/2017.
 * Receives the data sent to server.
 * https://stackoverflow.com/questions/1688099/converting-json-to-java
 {
 "appInfoId": 111,
 "userId": 222,
 "location": {
 "name": "",
 "longitude": 12.33,
 "latitude": 222.36,
 "altitude": 10,
 "elevation": 10,
 "type": ""
 },
 "region": {
 "name": "",
 "type": ""
 }
 }
 */
@Controller
@RequestMapping(path = "/data")
public class DataController {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    RegionRepository regionRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    String addNewUser(@RequestParam String jsonStr) {


        ObjectMapper mapper = new ObjectMapper();
        Data data;
        try {

            data = mapper.readValue(jsonStr, Data.class);
            int appInfoId = data.getAppInfoId();
            int userId = data.getUserId();
            Location location = data.getLocation();
            Region region = data.getRegion();
            //locationRepository.save(location);
            //regionRepository.save(region);
            //dataRepository.save(data);
            return mapper.writeValueAsString(data);
            //System.out.println(data);

            //jsonStr = mapper.writeValueAsString(data);

            //System.out.println(jsonStr);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "{status:'ERROR'}";
    }
}
