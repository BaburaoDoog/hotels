package com.hotel.booking.Repository;

import com.hotel.booking.Entity.Review;
import com.hotel.booking.Enums.Gender;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Integer> {

    @Query("From Review where userId=:userId and hotelId=:hotelId")
    Optional<Review> getReviewByUserId(@Param("userId")Integer userId,@Param("hotelId")int hotelId);

    @Query("select AVG(rating) from Review where hotelId=:hotelId")
    Integer averageRating(@Param("hotelId")int hotelId);

    @Query("from Review where userId in (:userId) and cityId=:cityId")
    List<Review> getAllReviewByGender(@Param("userId")List<Integer> userId,@Param("cityId") int cityId);
}
