package com.gamesys.spacetimetravel.service;

import com.gamesys.spacetimetravel.entity.SpaceTimeTravelInfoEntity;
import com.gamesys.spacetimetravel.exception.SpaceTimeTravelDetailsExistsException;
import com.gamesys.spacetimetravel.model.SpaceTimeTravelAvailabilityResponse;
import com.gamesys.spacetimetravel.repository.SpaceTimeTravelInfoRepository;
import com.gamesys.spacetimetravel.service.SpaceTimeTravelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.gamesys.spacetimetravel.constants.SpaceTimeTravelConstants.PGI_TRAVEL_INFO_EXISTS;
import static com.gamesys.spacetimetravel.constants.SpaceTimeTravelConstants.SUCCESSFULY_TRAVEL_DETAILS_UPDATED;

@Service
public class SpaceTimeTravelServiceImpl implements SpaceTimeTravelService {

    @Autowired
    private SpaceTimeTravelInfoRepository repository;

    @Override
    public SpaceTimeTravelAvailabilityResponse submitTravelDetails(SpaceTimeTravelInfoEntity timeTravelInfo) {
        if(ifTravelInfoExists(timeTravelInfo)){
            throw new SpaceTimeTravelDetailsExistsException(PGI_TRAVEL_INFO_EXISTS);
        }else{
            repository.save(timeTravelInfo);
        }
        return new SpaceTimeTravelAvailabilityResponse(SUCCESSFULY_TRAVEL_DETAILS_UPDATED);
    }


    private boolean ifTravelInfoExists(SpaceTimeTravelInfoEntity timeTravelInfo){
        List<SpaceTimeTravelInfoEntity> timeTravelInfoEntityList = repository.findTravelInfo(timeTravelInfo.getPgi(),timeTravelInfo.getPlace(),timeTravelInfo.getTravelDate());
        if(timeTravelInfoEntityList.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
