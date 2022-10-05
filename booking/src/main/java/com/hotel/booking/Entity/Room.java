package com.hotel.booking.Entity;

import com.hotel.booking.Requests.FacilityRequest;
import com.hotel.booking.Requests.RoomRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int noOfBeds;
    private boolean isACAvailable;

    public Room(RoomRequest roomRequest){
        this.noOfBeds=roomRequest.getNoOfBeds();
        this.isACAvailable=roomRequest.isACAvailable();

    }

}
