package com.gamesys.timetravel.service;

import com.gamesys.timetravel.entity.TimeTravelInfoEntity;
import com.gamesys.timetravel.exception.TimeTravelDetailsExistsException;
import com.gamesys.timetravel.model.TimeTravelAvailabilityResponse;
import com.gamesys.timetravel.model.TimeTravelInfo;
import com.gamesys.timetravel.repository.TimeTravelInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.gamesys.timetravel.constants.TimeTravelConstants.PGI_TRAVEL_INFO_EXISTS;
import static com.gamesys.timetravel.constants.TimeTravelConstants.SUCCESSFULY_TRAVEL_DETAILS_UPDATED;

@Service
public class TimeTravelServiceImpl implements TimeTravelService {

    @Autowired
    TimeTravelInfoRepository repository;

    @Override
    public TimeTravelAvailabilityResponse submitTravelDetails(TimeTravelInfoEntity timeTravelInfo) {
        if(ifTravelInfoExists(timeTravelInfo)){
            throw new TimeTravelDetailsExistsException(PGI_TRAVEL_INFO_EXISTS);
        }else{
            repository.save(timeTravelInfo);
        }
        return new TimeTravelAvailabilityResponse(SUCCESSFULY_TRAVEL_DETAILS_UPDATED);
    }


    private boolean ifTravelInfoExists(TimeTravelInfoEntity timeTravelInfo){
        List<TimeTravelInfoEntity> timeTravelInfoEntityList = repository.findTravelInfo(timeTravelInfo.getPgi(),timeTravelInfo.getPlace(),timeTravelInfo.getTravelDate());
        if(timeTravelInfoEntityList.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
