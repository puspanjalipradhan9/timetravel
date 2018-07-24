package com.gamesys.integration.spactimetravel;

import com.gamesys.spacetimetravel.SpaceTimeTravelApplication;
import com.gamesys.spacetimetravel.entity.SpaceTimeTravelInfoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Map;

import static com.gamesys.spacetimetravel.constants.SpaceTimeTravelConstants.SUCCESSFULY_TRAVEL_DETAILS_UPDATED;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpaceTimeTravelApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpaceTimeTravelIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    public static final String SPACE_TIME_TRAVEL_URI = "/spaceTimeTravel/submitTravelDetails";
    @Test
    public void submitTimeTravelDetailsWithIncompleteDate() throws Exception{
        SimpleDateFormat simepleDateFormat =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        SpaceTimeTravelInfoEntity spaceTimeTravelInfo = new SpaceTimeTravelInfoEntity("ABCDEF","NOWHERE",simepleDateFormat.parse("1999-01-02 22:55:01"));

        Map<String,String> responseMap = restTemplate.postForObject(SPACE_TIME_TRAVEL_URI, spaceTimeTravelInfo, Map.class);
        assertTrue(responseMap.containsKey("error"));
        assertTrue(responseMap.get("message").equals("The Pgi has already a travel plan for the same destination and at the same Date."));
    }

    @Test
    public void submitSuccessfulTimeTravelDetails() throws Exception{
        SimpleDateFormat simepleDateFormat =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        SpaceTimeTravelInfoEntity spaceTimeTravelInfo = new SpaceTimeTravelInfoEntity("ABCDEF","NOWHERE",simepleDateFormat.parse("1999-01-02 22:55:01"));

        Map<String,String> responseMap = restTemplate.postForObject(SPACE_TIME_TRAVEL_URI, spaceTimeTravelInfo, Map.class);
        assertTrue(!responseMap.containsKey("error"));
        assertEquals(responseMap.get("statusMsg"),(SUCCESSFULY_TRAVEL_DETAILS_UPDATED));

    }

    @Test
    public void submitSuccessfulTimeTravelDetailsTwice() throws Exception{
        SimpleDateFormat simepleDateFormat =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        SpaceTimeTravelInfoEntity spaceTimeTravelInfo = new SpaceTimeTravelInfoEntity("ABCDEF","NOWHERE",simepleDateFormat.parse("1999-01-02 22:55:10"));

        Map<String,String> responseMap = restTemplate.postForObject(SPACE_TIME_TRAVEL_URI, spaceTimeTravelInfo, Map.class);
        assertTrue(!responseMap.containsKey("error"));
        assertEquals(responseMap.get("statusMsg"),(SUCCESSFULY_TRAVEL_DETAILS_UPDATED));


        responseMap = restTemplate.postForObject(SPACE_TIME_TRAVEL_URI, spaceTimeTravelInfo, Map.class);
        assertTrue(responseMap.containsKey("error"));
    }

}
