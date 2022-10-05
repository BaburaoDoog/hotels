package com.hotel.booking.Service;

import com.hotel.booking.Entity.City;
import com.hotel.booking.Entity.Facility;
import com.hotel.booking.Entity.Hotel;
import com.hotel.booking.Entity.Room;
import com.hotel.booking.Exception.CustomException;
import com.hotel.booking.Repository.CityRepository;
import com.hotel.booking.Repository.FacilityRepository;
import com.hotel.booking.Repository.HotelRepository;
import com.hotel.booking.Repository.RoomRepository;
import com.hotel.booking.Requests.CityRequest;
import com.hotel.booking.Requests.FacilityRequest;
import com.hotel.booking.Requests.HotelRequest;
import com.hotel.booking.Requests.RoomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HotelRepository hotelRepository;

    public City createCity(CityRequest cityRequest){
        City city=new City(cityRequest);
        return cityRepository.save(city);
    }

    public Room createRooms(RoomRequest roomRequest){
        Room room=new Room(roomRequest);
        return roomRepository.save(room);
    }

    public Hotel createHotel(HotelRequest hotelRequest){
        Hotel hotel=new Hotel(hotelRequest);
        return hotelRepository.save(hotel);
    }

    public Optional<Hotel> getHotelById(int id)throws CustomException {
         Optional<Hotel> hotel=hotelRepository.findById(id);
         if(!hotel.isPresent()){
             throw new CustomException("Hotel not found");
         }
        return hotel;
    }

    public Hotel updateHotel(HotelRequest hotelRequest,int hotelId)throws CustomException{
        Optional<Hotel> hotelById=getHotelById(hotelId);
        Hotel hotel = null;
        if(hotelById.isPresent()) {
             hotel = new Hotel(hotelRequest, hotelById.get().getId(),hotelById.get().getFacility().getId());
            return hotelRepository.save(hotel);
        }
        return hotel;
    }

    public void deleteHotel(int id){
        hotelRepository.deleteById(id);
    }

}
