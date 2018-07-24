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

/**
 * The SpaceTimeTravelServiceImpl contains the  implementation of the operation of Interface SpaceTimeTravelService
 *
 * @author  Puspanjali Pradhan
 * @version 1.0
 * @since   2018-07-24
 */
@Service
public class SpaceTimeTravelServiceImpl implements SpaceTimeTravelService {

    @Autowired
    private SpaceTimeTravelInfoRepository repository;

    @Override
    public SpaceTimeTravelAvailabilityResponse submitTravelDetails(SpaceTimeTravelInfoEntity spaceTimeTravelInfo) {
        if(ifTravelInfoExists(spaceTimeTravelInfo)){
            throw new SpaceTimeTravelDetailsExistsException(PGI_TRAVEL_INFO_EXISTS);
        }else{
            repository.save(spaceTimeTravelInfo);
        }
        return new SpaceTimeTravelAvailabilityResponse(SUCCESSFULY_TRAVEL_DETAILS_UPDATED);
    }

    /**
     * This method checks if the Travel Information submitted already exists
     * @param spaceTimeTravelInfo SpaceTimeTravelInfoEntity .
     * @return boolean
     */
    private boolean ifTravelInfoExists(SpaceTimeTravelInfoEntity spaceTimeTravelInfo){
        List<SpaceTimeTravelInfoEntity> spaceTimeTravelInfoEntityList = repository.findTravelInfo(spaceTimeTravelInfo.getPgi(),spaceTimeTravelInfo.getPlace(),spaceTimeTravelInfo.getTravelDate());
        if(spaceTimeTravelInfoEntityList.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
