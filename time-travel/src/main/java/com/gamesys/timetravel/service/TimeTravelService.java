package com.gamesys.timetravel.service;

import com.gamesys.timetravel.entity.TimeTravelInfoEntity;
import com.gamesys.timetravel.model.TimeTravelAvailabilityResponse;

public interface TimeTravelService {
     TimeTravelAvailabilityResponse submitTravelDetails(TimeTravelInfoEntity timeTravelInfo);
}

