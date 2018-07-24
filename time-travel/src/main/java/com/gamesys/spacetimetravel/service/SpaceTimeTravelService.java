package com.gamesys.spacetimetravel.service;

import com.gamesys.spacetimetravel.entity.SpaceTimeTravelInfoEntity;
import com.gamesys.spacetimetravel.model.SpaceTimeTravelAvailabilityResponse;


public interface SpaceTimeTravelService {
     SpaceTimeTravelAvailabilityResponse submitTravelDetails(SpaceTimeTravelInfoEntity timeTravelInfo);
}

