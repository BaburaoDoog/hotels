package com.hotel.booking.Requests;

import lombok.Data;

@Data
public class CityRequest {

    private String name;
    private String taluka;
    private String district;
    private String location;
    private String landmark;
    private int pincode;
}
