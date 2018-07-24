package com.gamesys.spacetimetravel.service;

import com.gamesys.spacetimetravel.entity.SpaceTimeTravelInfoEntity;
import com.gamesys.spacetimetravel.model.SpaceTimeTravelAvailabilityResponse;

/**
 * The SpaceTimeTravelService contains the  operations for Space Time Travel
 *
 * @author  Puspanjali Pradhan
 * @version 1.0
 * @since   2018-07-24
 */
public interface SpaceTimeTravelService {
     /**
      * This method corresponds to the operation where it is checked if the submitted Travel information can be fetched
      * @param spaceTimeTravelInfo SpaceTimeTravelInfoEntity .
      * @return SpaceTimeTravelAvailabilityResponse
      */
     SpaceTimeTravelAvailabilityResponse submitTravelDetails(SpaceTimeTravelInfoEntity spaceTimeTravelInfo);
}

