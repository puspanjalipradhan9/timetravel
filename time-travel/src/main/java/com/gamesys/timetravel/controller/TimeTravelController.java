package com.gamesys.timetravel.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.gamesys.timetravel.model.TimeTravelAvailabilityResponse;
import com.gamesys.timetravel.model.TimeTravelInfo;
import com.gamesys.timetravel.service.TimeTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/timetravel")
public class TimeTravelController {

    @Autowired
    TimeTravelService timeTravelService;

    @RequestMapping(value="/submitTravelDetails",method=RequestMethod.POST)
    public ResponseEntity<TimeTravelAvailabilityResponse> submitTravelDetails(@Valid @RequestBody TimeTravelInfo timeTravelInfo) {
        TimeTravelAvailabilityResponse response = timeTravelService.submitTravelDetails(timeTravelInfo);
        return  new ResponseEntity<TimeTravelAvailabilityResponse>(response,HttpStatus.OK);
    }
}
