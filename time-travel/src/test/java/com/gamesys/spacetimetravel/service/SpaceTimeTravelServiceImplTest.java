package com.gamesys.spacetimetravel.service;

import com.gamesys.spacetimetravel.entity.SpaceTimeTravelInfoEntity;
import com.gamesys.spacetimetravel.exception.SpaceTimeTravelDetailsExistsException;
import com.gamesys.spacetimetravel.model.SpaceTimeTravelAvailabilityResponse;
import com.gamesys.spacetimetravel.repository.SpaceTimeTravelInfoRepository;
import com.gamesys.spacetimetravel.service.SpaceTimeTravelServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.gamesys.spacetimetravel.constants.SpaceTimeTravelConstants.SUCCESSFULY_TRAVEL_DETAILS_UPDATED;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SpaceTimeTravelServiceImplTest {

    @Mock
    SpaceTimeTravelInfoRepository repository;

    @InjectMocks
    SpaceTimeTravelServiceImpl timeTravelServiceImpl;

    public static final SimpleDateFormat DATE_FORMAT =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");

    @Before
    public void setUp(){
    }

    @Test(expected = SpaceTimeTravelDetailsExistsException.class)
    public  void testSubmitTravelDetailsWhenTravelDetailsAlreadyExists() throws ParseException {
        List<SpaceTimeTravelInfoEntity> timeTravelInfoEntityList = new ArrayList<>();
        SpaceTimeTravelInfoEntity timeTravelInfo = new SpaceTimeTravelInfoEntity("ABCDEF","NOWHERE",DATE_FORMAT.parse("1999-01-02 22:55:10"));
        timeTravelInfoEntityList.add(timeTravelInfo);

        when(repository.findTravelInfo(any(String.class),any(String.class),any(Date.class))).thenReturn(timeTravelInfoEntityList);

        timeTravelInfo = new SpaceTimeTravelInfoEntity("ABCDEF","NOWHERE",DATE_FORMAT.parse("1999-01-02 22:55:10"));
        SpaceTimeTravelAvailabilityResponse response = timeTravelServiceImpl.submitTravelDetails(timeTravelInfo);
        assertTrue(SUCCESSFULY_TRAVEL_DETAILS_UPDATED.equals(response.getStatusMsg()));
    }


    @Test
    public  void testSubmitTravelDetailsWhenTravelDetailsDoesNotExists() throws ParseException {
        when(repository.findTravelInfo(any(String.class),any(String.class),any(Date.class))).thenReturn(new ArrayList<SpaceTimeTravelInfoEntity>());

        SpaceTimeTravelInfoEntity timeTravelInfo = new SpaceTimeTravelInfoEntity("ABCDEF","NOWHERE",DATE_FORMAT.parse("1999-01-02 22:55:10"));
        SpaceTimeTravelAvailabilityResponse response = timeTravelServiceImpl.submitTravelDetails(timeTravelInfo);
        assertTrue(SUCCESSFULY_TRAVEL_DETAILS_UPDATED.equals(response.getStatusMsg()));
    }

}
