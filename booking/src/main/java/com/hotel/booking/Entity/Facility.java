package com.hotel.booking.Entity;

import com.hotel.booking.Requests.FacilityRequest;
import com.hotel.booking.Requests.HotelRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String facility1;
    private String facility2;
    private String facility3;
    private String facility4;
    private boolean isWiFiAvailable;
    private boolean isMealsAvailable;
    private int noOfRooms;
    private int noOfBeds;

    public Facility(FacilityRequest facilityRequest){
        this.facility1=facilityRequest.getFacility1();
        this.facility2=facilityRequest.getFacility2();
        this.facility3=facilityRequest.getFacility3();
        this.facility4=facilityRequest.getFacility4();
        this.isWiFiAvailable=facilityRequest.isWiFiAvailable();
        this.isMealsAvailable=facilityRequest.isMealsAvailable();
        this.noOfBeds=facilityRequest.getNoOfBeds();
        this.noOfRooms= facilityRequest.getNoOfRooms();
    }
    public Facility(HotelRequest hotelRequest){
        this.facility1=hotelRequest.getFacility1();
        this.facility2=hotelRequest.getFacility2();
        this.facility3=hotelRequest.getFacility3();
        this.facility4=hotelRequest.getFacility4();
        this.isWiFiAvailable=hotelRequest.isWiFiAvailable();
        this.isMealsAvailable=hotelRequest.isMealsAvailable();
        this.noOfBeds=hotelRequest.getNoOfBeds();
        this.noOfRooms= hotelRequest.getNoOfRooms();
    }
}
