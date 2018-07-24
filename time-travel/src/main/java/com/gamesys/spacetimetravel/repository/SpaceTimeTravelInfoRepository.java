package com.gamesys.spacetimetravel.repository;


import com.gamesys.spacetimetravel.entity.SpaceTimeTravelInfoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SpaceTimeTravelInfoRepository  extends CrudRepository<SpaceTimeTravelInfoEntity, Integer> {
    String FETCH_MINIMUM_DISTANCE = "SELECT id,pgi,place,travel_date from  space_time_travel_info where pgi=:pgi and place=:place and travel_date=:travel_date";

    @Query(value=FETCH_MINIMUM_DISTANCE, nativeQuery = true)
    List<SpaceTimeTravelInfoEntity> findTravelInfo(@Param("pgi")String pgi, @Param("place") String place, @Param("travel_date") Date travelDate);
}
