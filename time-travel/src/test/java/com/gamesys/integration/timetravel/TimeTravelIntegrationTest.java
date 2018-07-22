package com.gamesys.integration.timetravel;

import com.gamesys.timetravel.TimeTravelApplication;
import com.gamesys.timetravel.model.TimeTravelAvailabilityResponse;
import com.gamesys.timetravel.model.TimeTravelInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Map;

import static com.gamesys.timetravel.constants.TimeTravelConstants.SUCCESSFULY_TRAVEL_DETAILS_UPDATED;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimeTravelApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TimeTravelIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void submitSuccessfulTimeTravelDetails() throws Exception{
        SimpleDateFormat simepleDateFormat =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        TimeTravelInfo timeTravelInfo = new TimeTravelInfo("ABCDEF","NOWHERE",simepleDateFormat.parse("1999-01-02 22:55:01"));

        Map<String,String> responseMap = restTemplate.postForObject("/timetravel/submitTravelDetails", timeTravelInfo, Map.class);
        assertTrue(!responseMap.containsKey("error"));
        assertEquals(responseMap.get("statusMsg"),(SUCCESSFULY_TRAVEL_DETAILS_UPDATED));

    }

    @Test
    public void submitSuccessfulTimeTravelDetailsTwice() throws Exception{
        SimpleDateFormat simepleDateFormat =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        TimeTravelInfo timeTravelInfo = new TimeTravelInfo("ABCDEF","NOWHERE",simepleDateFormat.parse("1999-01-02 22:55:10"));

        Map<String,String> responseMap = restTemplate.postForObject("/timetravel/submitTravelDetails", timeTravelInfo, Map.class);
        assertTrue(!responseMap.containsKey("error"));
        assertEquals(responseMap.get("statusMsg"),(SUCCESSFULY_TRAVEL_DETAILS_UPDATED));


        responseMap = restTemplate.postForObject("/timetravel/submitTravelDetails", timeTravelInfo, Map.class);
        assertTrue(responseMap.containsKey("error"));
    }

}
