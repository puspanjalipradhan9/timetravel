package com.gamesys.timetravel.controller;


import com.gamesys.timetravel.entity.TimeTravelInfoEntity;
import com.gamesys.timetravel.model.TimeTravelAvailabilityResponse;
import com.gamesys.timetravel.service.TimeTravelService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.gamesys.timetravel.constants.TimeTravelConstants.PGI_TRAVEL_INFO_EXISTS;
import static com.gamesys.timetravel.constants.TimeTravelConstants.SUCCESSFULY_TRAVEL_DETAILS_UPDATED;


@RestController
@RequestMapping(value="/timetravel")
@Api(value="timetravel", description="Operations pertaining to Time Travel")
public class TimeTravelController {

    @Autowired
    TimeTravelService timeTravelService;


    @ApiOperation(value = "Submit the Travel Details", response = TimeTravelAvailabilityResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SUCCESSFULY_TRAVEL_DETAILS_UPDATED),
            @ApiResponse(code = 409, message = PGI_TRAVEL_INFO_EXISTS),
            @ApiResponse(code = 400, message = "PGI value cannot be null"),
        }
    )

    @RequestMapping(value="/submitTravelDetails",method=RequestMethod.POST,produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TimeTravelAvailabilityResponse> submitTravelDetails(
    @Valid @RequestBody TimeTravelInfoEntity timeTravelInfo) {
        TimeTravelAvailabilityResponse response = timeTravelService.submitTravelDetails(timeTravelInfo);
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }
}
