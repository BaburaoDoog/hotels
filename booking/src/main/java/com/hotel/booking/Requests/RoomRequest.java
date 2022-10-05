package com.hotel.booking.Requests;

import lombok.Data;

@Data
public class RoomRequest {


    private int noOfBeds;
    private boolean isACAvailable;
}
