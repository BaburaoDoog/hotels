package com.hotel.booking.Requests;

import com.hotel.booking.Entity.Facility;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class HotelRequest {

    private String name;
    private int cityId;

    private String startTime;
    private String endTime;

    private String facility1;
    private String facility2;
    private String facility3;
    private String facility4;
    private boolean isWiFiAvailable;
    private boolean isMealsAvailable;
    private int noOfRooms;
    private int noOfBeds;
    private boolean isHotelOpenToday;
    private double bedPrice;
}
