package com.hotel.booking.Requests;

import com.hotel.booking.Entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class ReviewRequest {

    private Integer userId;
    private String feedback;
    private int hotelId;
    private int cityId;
    private long rating;
    private Date createdOn;
}
