package com.gamesys.spacetimetravel.controller;

import com.gamesys.spacetimetravel.controller.SpaceTimeTravelController;
import com.gamesys.spacetimetravel.entity.SpaceTimeTravelInfoEntity;
import com.gamesys.spacetimetravel.model.SpaceTimeTravelAvailabilityResponse;
import com.gamesys.spacetimetravel.service.SpaceTimeTravelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.gamesys.spacetimetravel.constants.SpaceTimeTravelConstants.SUCCESSFULY_TRAVEL_DETAILS_UPDATED;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SpaceTimeTravelControllerTest {
    @Mock
    SpaceTimeTravelService timeTravelService;
    @InjectMocks
    SpaceTimeTravelController timeTravelController;

    public static final SimpleDateFormat DATE_FORMAT =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
    @Test
    public void testSubmitTravelDetailsWithValidDetails() throws ParseException {
        SpaceTimeTravelInfoEntity timeTravelInfo = new SpaceTimeTravelInfoEntity("ABCDEF","NOWHERE",DATE_FORMAT.parse("1999-01-02 22:55:10"));

        when(timeTravelService.submitTravelDetails(timeTravelInfo)).thenReturn(new SpaceTimeTravelAvailabilityResponse(SUCCESSFULY_TRAVEL_DETAILS_UPDATED));
        ResponseEntity<SpaceTimeTravelAvailabilityResponse> response = timeTravelController.submitTravelDetails(timeTravelInfo);
        assertTrue(response.getStatusCode().equals(HttpStatus.OK));
    }
}
