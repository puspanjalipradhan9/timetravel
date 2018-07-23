package com.gamesys.timetravel.controller;

import com.gamesys.timetravel.entity.TimeTravelInfoEntity;
import com.gamesys.timetravel.model.TimeTravelAvailabilityResponse;
import com.gamesys.timetravel.service.TimeTravelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.gamesys.timetravel.constants.TimeTravelConstants.SUCCESSFULY_TRAVEL_DETAILS_UPDATED;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TimeTravelControllerTest {
    @Mock
    TimeTravelService timeTravelService;
    @InjectMocks
    TimeTravelController timeTravelController;

    public static final SimpleDateFormat DATE_FORMAT =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
    @Test
    public void testSubmitTravelDetailsWithValidDetails() throws ParseException {
        TimeTravelInfoEntity timeTravelInfo = new TimeTravelInfoEntity("ABCDEF","NOWHERE",DATE_FORMAT.parse("1999-01-02 22:55:10"));

        when(timeTravelService.submitTravelDetails(timeTravelInfo)).thenReturn(new TimeTravelAvailabilityResponse(SUCCESSFULY_TRAVEL_DETAILS_UPDATED));
        ResponseEntity<TimeTravelAvailabilityResponse> response = timeTravelController.submitTravelDetails(timeTravelInfo);
        assertTrue(response.getStatusCode().equals(HttpStatus.OK));
    }
}
