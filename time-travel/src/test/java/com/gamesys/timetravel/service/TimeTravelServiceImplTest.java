package com.gamesys.timetravel.service;

import com.gamesys.timetravel.entity.TimeTravelInfoEntity;
import com.gamesys.timetravel.exception.TimeTravelDetailsExistsException;
import com.gamesys.timetravel.model.TimeTravelAvailabilityResponse;
import com.gamesys.timetravel.repository.TimeTravelInfoRepository;
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

import static com.gamesys.timetravel.constants.TimeTravelConstants.SUCCESSFULY_TRAVEL_DETAILS_UPDATED;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TimeTravelServiceImplTest {

    @Mock
    TimeTravelInfoRepository repository;

    @InjectMocks
    TimeTravelServiceImpl timeTravelServiceImpl;

    public static final SimpleDateFormat DATE_FORMAT =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");

    @Before
    public void setUp(){
    }

    @Test(expected = TimeTravelDetailsExistsException.class)
    public  void testSubmitTravelDetailsWhenTravelDetailsAlreadyExists() throws ParseException {
        List<TimeTravelInfoEntity> timeTravelInfoEntityList = new ArrayList<>();
        TimeTravelInfoEntity timeTravelInfo = new TimeTravelInfoEntity("ABCDEF","NOWHERE",DATE_FORMAT.parse("1999-01-02 22:55:10"));
        timeTravelInfoEntityList.add(timeTravelInfo);

        when(repository.findTravelInfo(any(String.class),any(String.class),any(Date.class))).thenReturn(timeTravelInfoEntityList);

        timeTravelInfo = new TimeTravelInfoEntity("ABCDEF","NOWHERE",DATE_FORMAT.parse("1999-01-02 22:55:10"));
        TimeTravelAvailabilityResponse response = timeTravelServiceImpl.submitTravelDetails(timeTravelInfo);
        assertTrue(SUCCESSFULY_TRAVEL_DETAILS_UPDATED.equals(response.getStatusMsg()));
    }


    @Test
    public  void testSubmitTravelDetailsWhenTravelDetailsDoesNotExists() throws ParseException {
        when(repository.findTravelInfo(any(String.class),any(String.class),any(Date.class))).thenReturn(new ArrayList<TimeTravelInfoEntity>());

        TimeTravelInfoEntity timeTravelInfo = new TimeTravelInfoEntity("ABCDEF","NOWHERE",DATE_FORMAT.parse("1999-01-02 22:55:10"));
        TimeTravelAvailabilityResponse response = timeTravelServiceImpl.submitTravelDetails(timeTravelInfo);
        assertTrue(SUCCESSFULY_TRAVEL_DETAILS_UPDATED.equals(response.getStatusMsg()));
    }

}
