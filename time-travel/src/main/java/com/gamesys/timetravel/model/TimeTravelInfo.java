package com.gamesys.timetravel.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Component
public class TimeTravelInfo {
    @NotNull(message = "PGI value cannot be null")
    @Pattern(regexp="^[a-zA-Z][a-zA-Z0-9.,$;]{4,9}+$",message="value must be alphanumeric and always starts with a letter and between 5-10 characters")
    private String pgi;

    @NotNull(message = "Place value cannot be null")
    private String place;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "Travel Date value cannot be null")
    private Date travelDate;

    public TimeTravelInfo(){
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
