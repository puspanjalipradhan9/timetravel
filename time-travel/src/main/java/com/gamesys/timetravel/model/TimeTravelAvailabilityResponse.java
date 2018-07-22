package com.gamesys.timetravel.model;

public class TimeTravelAvailabilityResponse {
    private String statusMsg;

    public TimeTravelAvailabilityResponse(String statusMsg){
        this.statusMsg = statusMsg;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
}
