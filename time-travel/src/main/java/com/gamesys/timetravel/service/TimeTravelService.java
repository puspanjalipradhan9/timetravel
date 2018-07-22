package com.gamesys.timetravel.service;

import com.gamesys.timetravel.model.TimeTravelAvailabilityResponse;
import com.gamesys.timetravel.model.TimeTravelInfo;


public interface TimeTravelService {
     TimeTravelAvailabilityResponse submitTravelDetails(TimeTravelInfo timeTravelInfo);
}

