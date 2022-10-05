package com.hotel.booking.Entity;

import com.hotel.booking.Requests.CityRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String taluka;
    private String district;
    private String location;
    private String landmark;
    private int pincode;

    public City(CityRequest cityRequest){
        this.name=cityRequest.getName();
        this.taluka=cityRequest.getTaluka();
        this.district=cityRequest.getDistrict();
        this.location=cityRequest.getLocation();
        this.landmark=cityRequest.getLandmark();
        this.pincode=cityRequest.getPincode();
    }
}
