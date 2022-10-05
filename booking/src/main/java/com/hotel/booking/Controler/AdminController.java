package com.hotel.booking.Controler;

import com.hotel.booking.Entity.City;
import com.hotel.booking.Entity.Hotel;
import com.hotel.booking.Entity.Room;
import com.hotel.booking.Exception.CustomException;
import com.hotel.booking.Requests.CityRequest;
import com.hotel.booking.Requests.HotelRequest;
import com.hotel.booking.Requests.RoomRequest;
import com.hotel.booking.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/createNewCity")
    public ResponseEntity<City> createNewCity(CityRequest cityRequest){
       return ResponseEntity.ok().body(adminService.createCity(cityRequest));
    }

    @PostMapping("/createRooms")
    public ResponseEntity<Room> createRooms(RoomRequest roomRequest){
        return ResponseEntity.ok().body(adminService.createRooms(roomRequest));
    }
    @PostMapping("/createHotel")
    public ResponseEntity<Hotel> createHotel(HotelRequest hotelRequest){
        return ResponseEntity.ok().body(adminService.createHotel(hotelRequest));
    }

    @PutMapping("/updateHotel/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(HotelRequest hotelRequest, @PathVariable("hotelId")int hotelId)throws CustomException {
        return ResponseEntity.ok().body(adminService.updateHotel(hotelRequest,hotelId));
    }

    @DeleteMapping("/deleteHotel/{id}")
    public void deleteHotel(@PathVariable("id")int id){
        adminService.deleteHotel(id);
    }


}
