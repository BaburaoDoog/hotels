package com.hotel.booking.Repository;

import com.hotel.booking.Entity.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {

    @Query("from Hotel where cityId=:cityId and isHotelOpenToday=:isHotelOpenToday")
    List<Hotel> searchHotelByCityIdAndAvailability(@Param("cityId")Integer cityId,@Param("isHotelOpenToday")boolean isHotelOpenToday);

    @Query("from Hotel where cityId=:cityId")
    List<Hotel> getHotelsByCityId(@Param("cityId")int cityId);
}
