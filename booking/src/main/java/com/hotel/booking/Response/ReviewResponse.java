package com.hotel.booking.Response;

import com.hotel.booking.Entity.Hotel;
import com.hotel.booking.Entity.Review;
import com.hotel.booking.Entity.User;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class ReviewResponse {

    private int id;
    private User user;
    private Hotel hotel;
    private int cityId;
    private String feedback;

    private long rating; //ratings are out of 10
    @Column(updatable = false,insertable = true)
    private Date createdOn;


}
