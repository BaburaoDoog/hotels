package com.hotel.booking.Repository;

import com.hotel.booking.Entity.User;
import com.hotel.booking.Enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    @Query("from User where gender=:gender")
    List<User> getAllUsersByGender(@Param("gender")Gender gender);

}
