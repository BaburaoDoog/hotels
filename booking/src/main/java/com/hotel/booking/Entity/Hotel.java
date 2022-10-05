package com.hotel.booking.Entity;

import com.hotel.booking.Requests.HotelRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int cityId;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "facility_id")
    private Facility facility;
    private String startTime;
    private String endTime;
    private boolean isHotelOpenToday;
    private long overalRating;
    private double bedPrice;   //it will be the per bed price

    public Hotel(HotelRequest hotelRequest){
        this.name=hotelRequest.getName();
        this.cityId=hotelRequest.getCityId();
        this.startTime=hotelRequest.getStartTime();
        this.endTime=hotelRequest.getEndTime();
        this.isHotelOpenToday=hotelRequest.isHotelOpenToday();
        this.bedPrice=hotelRequest.getBedPrice();
        Facility facility=Facility.builder()
                .facility1(hotelRequest.getFacility1())
                .facility2(hotelRequest.getFacility2())
                .facility3(hotelRequest.getFacility3())
                .facility4(hotelRequest.getFacility4())
                .isMealsAvailable(hotelRequest.isMealsAvailable())
                .noOfRooms(hotelRequest.getNoOfRooms())
                .noOfBeds(hotelRequest.getNoOfBeds())
                .isWiFiAvailable(hotelRequest.isWiFiAvailable())
                .build();
        this.facility=facility;
    }
    public Hotel(HotelRequest hotelRequest,int hotelId,int facilityId){
        this.id=hotelId;
        this.name=hotelRequest.getName();
        this.cityId=hotelRequest.getCityId();
        this.startTime=hotelRequest.getStartTime();
        this.endTime=hotelRequest.getEndTime();
        this.isHotelOpenToday=hotelRequest.isHotelOpenToday();
        this.bedPrice=hotelRequest.getBedPrice();
        Facility facility=Facility.builder()
                .id(facilityId)
                .facility1(hotelRequest.getFacility1())
                .facility2(hotelRequest.getFacility2())
                .facility3(hotelRequest.getFacility3())
                .facility4(hotelRequest.getFacility4())
                .isMealsAvailable(hotelRequest.isMealsAvailable())
                .noOfRooms(hotelRequest.getNoOfRooms())
                .noOfBeds(hotelRequest.getNoOfBeds())
                .isWiFiAvailable(hotelRequest.isWiFiAvailable())
                .build();
        this.facility=facility;
    }
}
