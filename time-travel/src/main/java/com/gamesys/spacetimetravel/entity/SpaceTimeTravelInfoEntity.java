package com.gamesys.spacetimetravel.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Component
@Entity
@javax.persistence.Table(name = "space_time_travel_info")
public class SpaceTimeTravelInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id;

    @Column(name = "pgi")
    @NotNull(message = "PGI value cannot be null")
    @Pattern(regexp="^[a-zA-Z][a-zA-Z0-9.,$;]{4,9}+$",message="value must be alphanumeric and always starts with a letter and between 5-10 characters")
    @ApiModelProperty(notes = "Personal Galactic Identifier of the Individual",required = true)
    private String pgi;

    @Column(name = "place")
    @NotNull(message = "Place value cannot be null")
    @ApiModelProperty(notes = "The destination the Individual intends to travel to.",required = true)
    private String place;

    @Column(name = "travel_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "Travel Date value cannot be null")
    @ApiModelProperty(notes = "The intended travel date.",required = true)
    private Date travelDate;

    public SpaceTimeTravelInfoEntity(){
    }

    public SpaceTimeTravelInfoEntity(String pgi,String place,Date travelDate){
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
