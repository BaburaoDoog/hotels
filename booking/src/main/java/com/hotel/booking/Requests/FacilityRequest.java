package com.hotel.booking.Requests;

import lombok.Data;

import java.util.List;

@Data
public class FacilityRequest {

    private String facility1;
    private String facility2;
    private String facility3;
    private String facility4;
    private boolean isWiFiAvailable;
    private boolean isMealsAvailable;
    private int noOfBeds;
    private int noOfRooms;

}
