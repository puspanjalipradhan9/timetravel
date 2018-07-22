package com.gamesys.timetravel.repository;


import com.gamesys.timetravel.entity.TimeTravelInfoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TimeTravelInfoRepository  extends CrudRepository<TimeTravelInfoEntity, Integer> {
    String FETCH_MINIMUM_DISTANCE = "SELECT id,pgi,place,travel_date from  time_travel_info where pgi=:pgi and place=:place and travel_date=:travel_date";

    @Query(value=FETCH_MINIMUM_DISTANCE, nativeQuery = true)
    List<TimeTravelInfoEntity> findTravelInfo( @Param("pgi")String pgi,@Param("place") String place,@Param("travel_date") Date travelDate);
}
