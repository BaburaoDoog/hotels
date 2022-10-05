package com.hotel.booking.Entity;

import com.hotel.booking.Requests.ReviewRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer userId;
    private int hotelId;
    private int cityId;
    private String feedback;

    private long rating; //ratings are out of 10
    @Column(updatable = false,insertable = true)
    private Date createdOn;

    public Review(ReviewRequest reviewRequest){
        this.feedback=reviewRequest.getFeedback();
        this.userId=reviewRequest.getUserId();
        this.hotelId=reviewRequest.getHotelId();
        this.rating=reviewRequest.getRating();
        this.cityId=reviewRequest.getCityId();
        this.createdOn=reviewRequest.getCreatedOn();
    }
}
