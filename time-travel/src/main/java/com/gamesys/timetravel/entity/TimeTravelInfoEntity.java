package com.gamesys.timetravel.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gamesys.timetravel.model.TimeTravelInfo;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Component
@Entity
@javax.persistence.Table(name = "time_travel_info")
public class TimeTravelInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "pgi")
    @NotNull(message = "PGI value cannot be null")
    @Pattern(regexp="^[a-zA-Z][a-zA-Z0-9.,$;]{4,9}+$",message="value must be alphanumeric and always starts with a letter and between 5-10 characters")
    private String pgi;

    @Column(name = "place")
    @NotNull(message = "Place value cannot be null")
    private String place;

    @Column(name = "travel_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "Travel Date value cannot be null")
    private Date travelDate;

    public TimeTravelInfoEntity(){
    }

    public TimeTravelInfoEntity(String pgi,String place,Date travelDate){
        this.pgi = pgi;
        this.place = place;
        this.travelDate = travelDate;
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
