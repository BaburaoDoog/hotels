package com.hotel.booking.Controler;

import com.hotel.booking.Entity.Hotel;
import com.hotel.booking.Entity.Review;
import com.hotel.booking.Entity.User;
import com.hotel.booking.Enums.Gender;
import com.hotel.booking.Exception.CustomException;
import com.hotel.booking.Requests.ReviewRequest;
import com.hotel.booking.Requests.UserRequest;
import com.hotel.booking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControler {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(UserRequest userRequest){
        return ResponseEntity.ok().body(userService.createNewUser(userRequest));
    }

    @PostMapping("/createReview")
    public ResponseEntity<Review> createReview(ReviewRequest review)throws CustomException {
        return ResponseEntity.ok().body(userService.createReview(review));
    }

    @GetMapping("/searchHotels/cityId/{cityId}/availability/{availability}")
    public ResponseEntity<List<Hotel>> searchHotelsBy(@PathVariable("cityId")int cityId, @PathVariable("availability")boolean availability)throws CustomException {
        return ResponseEntity.ok().body(userService.searchByCityIdAndAvailability(cityId,availability));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id")int id,UserRequest userRequest)throws CustomException{
        return ResponseEntity.ok().body(userService.updateUser(userRequest,id));
    }

    @GetMapping("/getAllReviews/{cityId}/{gender}")
    public ResponseEntity<List<Review>> getAllReviewByGenderAndCityId(@PathVariable("cityId")int cityId,
                                                                      @PathVariable("gender")Gender gender){
        return ResponseEntity.ok().body(userService.getAllReviewsByCityAndGender(cityId,gender));
    }

    @DeleteMapping("/deleteReview/{id}")
    public void deleteReviewByID(@PathVariable("id")int id){
        userService.deleteReview(id);
    }
}
