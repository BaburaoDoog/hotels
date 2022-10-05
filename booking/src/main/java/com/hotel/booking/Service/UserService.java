package com.hotel.booking.Service;

import com.hotel.booking.Entity.City;
import com.hotel.booking.Entity.Hotel;
import com.hotel.booking.Entity.Review;
import com.hotel.booking.Entity.User;
import com.hotel.booking.Enums.Gender;
import com.hotel.booking.Exception.CustomException;
import com.hotel.booking.Repository.CityRepository;
import com.hotel.booking.Repository.HotelRepository;
import com.hotel.booking.Repository.ReviewRepository;
import com.hotel.booking.Repository.UserRepository;
import com.hotel.booking.Requests.ReviewRequest;
import com.hotel.booking.Requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private CityRepository cityRepository;


    public User createNewUser(UserRequest userRequest){
        User user=new User(userRequest);
      return userRepository.save(user);
    }

    public Review createReview(ReviewRequest reviewRequest)throws CustomException{
        Review review=new Review(reviewRequest);
        Optional<User>  user=getUserById(reviewRequest.getUserId());
        Optional<Review> getReviewByUserIdAndHotel=reviewRepository.getReviewByUserId(reviewRequest.getUserId(),reviewRequest.getHotelId());
        Integer rating=reviewRepository.averageRating(reviewRequest.getHotelId());

        if(user.isPresent()) {
            if(!getReviewByUserIdAndHotel.isPresent()) {
                if(Objects.nonNull(rating)) {
                    Hotel hotel = getHotelById(reviewRequest.getHotelId());
                    hotel.setOveralRating(rating);
                    hotelRepository.save(hotel);
                }
                review = reviewRepository.save(review);
            }else {
                throw new CustomException("User already given feedback");
            }
        }
        return review;
    }

    public Optional<User> getUserById(int id)throws CustomException {
        Optional<User> userList=userRepository.findById(id);
        if (userList.isPresent()) {
            return userList;
        }
        throw new CustomException("User not found");

    }

    public List<Hotel> searchByCityIdAndAvailability(int cityId, boolean availability)throws CustomException{
        Optional<City> city=cityRepository.findById(cityId);
        if(!city.isPresent())
        throw new CustomException("Given city id is not found");
        return hotelRepository.searchHotelByCityIdAndAvailability(cityId,availability);
    }

    public Hotel getHotelById(int id){
        Optional<Hotel> getHotel=hotelRepository.findById(id);
        if(getHotel.isPresent()){
            return getHotel.get();
        }
        return null;
    }

    public User updateUser(UserRequest userRequest,int id)throws CustomException{
        User userList=getUserById(id).get();
        User user=null;
        if(Objects.nonNull(userList)) {
             user = new User(userRequest);
             user.setId(id);
             user.setCreatedOn(userList.getCreatedOn());
             user.setUpdatedOn(userRequest.getUpdatedOn());
            return userRepository.save(user);
        }
        return user;
    }

    public List<Review> getAllReviewsByCityAndGender(int cityId, Gender gender){
        List<User> users=userRepository.getAllUsersByGender(gender);
        System.out.println("Users "+users);
        List<Integer> ids=new ArrayList<>();
        for(User id :users){
            ids.add(id.getId());
        }
        System.out.println("ids "+ids.get(0));
        List<Review> reviews=reviewRepository.getAllReviewByGender(ids,cityId);
        System.out.println("reviews "+reviews);
        return reviews;
    }

    public void deleteReview(int id){
        reviewRepository.deleteById(id);
    }

}
