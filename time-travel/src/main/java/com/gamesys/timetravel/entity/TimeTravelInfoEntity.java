package com.gamesys.timetravel.entity;

import com.gamesys.timetravel.model.TimeTravelInfo;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@javax.persistence.Table(name = "time_travel_info")
public class TimeTravelInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "pgi")
    private String pgi;

    @Column(name = "place")
    private String place;

    @Column(name = "travel_date")
    private Date travelDate;

    public TimeTravelInfoEntity(){
    }

    public TimeTravelInfoEntity(TimeTravelInfo timeTravelInfo){
        this.pgi = timeTravelInfo.getPgi();
        this.place = timeTravelInfo.getPlace();
        this.travelDate = timeTravelInfo.getTravelDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPgi() {
        return pgi;
    }

    public void setPgi(String pgi) {
        this.pgi = pgi;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }
}
