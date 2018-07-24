package com.gamesys.spacetimetravel.controller;


import com.gamesys.spacetimetravel.entity.SpaceTimeTravelInfoEntity;
import com.gamesys.spacetimetravel.model.SpaceTimeTravelAvailabilityResponse;
import com.gamesys.spacetimetravel.service.SpaceTimeTravelService;
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

import static com.gamesys.spacetimetravel.constants.SpaceTimeTravelConstants.PGI_TRAVEL_INFO_EXISTS;
import static com.gamesys.spacetimetravel.constants.SpaceTimeTravelConstants.SUCCESSFULY_TRAVEL_DETAILS_UPDATED;

/**
 * The SpaceTimeTravelController contains the  operation pertaining to Time Travel
 *
 * @author  Puspanjali Pradhan
 * @version 1.0
 * @since   2018-07-24
 */

@RestController
@RequestMapping(value="/spaceTimeTravel")
@Api(value="Space Time Travel", description="Operations pertaining to Space Time Travel")
public class SpaceTimeTravelController {

    @Autowired
    SpaceTimeTravelService timeTravelService;


    @ApiOperation(value = "Submit the Travel Details", response = SpaceTimeTravelAvailabilityResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SUCCESSFULY_TRAVEL_DETAILS_UPDATED),
            @ApiResponse(code = 409, message = PGI_TRAVEL_INFO_EXISTS),
            @ApiResponse(code = 400, message = "PGI value cannot be null"),
        }
    )

    /**
     * This method corresponds to the operation where it is checked if the submitted Travel information can be fetched
     * @param timeTravelInfo SpaceTimeTravelInfoEntity .
     * @return ResponseEntity<SpaceTimeTravelAvailabilityResponse>
     */
    @RequestMapping(value="/submitTravelDetails",method=RequestMethod.POST,produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpaceTimeTravelAvailabilityResponse> submitTravelDetails(
    @Valid @RequestBody SpaceTimeTravelInfoEntity timeTravelInfo) {
        SpaceTimeTravelAvailabilityResponse response = timeTravelService.submitTravelDetails(timeTravelInfo);
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }
}
