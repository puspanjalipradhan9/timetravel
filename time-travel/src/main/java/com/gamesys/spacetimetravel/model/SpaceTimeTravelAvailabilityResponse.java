package com.gamesys.spacetimetravel.model;

public class SpaceTimeTravelAvailabilityResponse {
    private String statusMsg;

    public SpaceTimeTravelAvailabilityResponse(String statusMsg){
        this.statusMsg = statusMsg;
    }

    public String getStatusMsg() {
        return statusMsg;
    }
}
