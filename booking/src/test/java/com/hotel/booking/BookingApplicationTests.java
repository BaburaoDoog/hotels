package com.hotel.booking;

import com.hotel.booking.Entity.*;
import com.hotel.booking.Enums.Gender;
import com.hotel.booking.Exception.CustomException;
import com.hotel.booking.Requests.*;
import com.hotel.booking.Service.AdminService;
import com.hotel.booking.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class BookingApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;



	@Test
	public void createUser(){
		UserRequest userRequest=new UserRequest();
		userRequest.setFirstName("Baburao");
		userRequest.setLastName("Doog");
		userRequest.setNumber(9663893014L);
		userRequest.setEmail("baburaodoog400@gmail.com");
		userRequest.setGender(Gender.MALE);
		User user=userService.createNewUser(userRequest);
		Assertions.assertEquals(user.getEmail(),userRequest.getEmail());
		Assertions.assertEquals(user.getGender(),userRequest.getGender());
		Assertions.assertEquals(user.getNumber(),userRequest.getNumber());

	}
	@Test
	public void updateUser()throws CustomException {
		UserRequest userRequest=new UserRequest();
		userRequest.setFirstName("updated name");
		userRequest.setLastName("updated");
		userRequest.setNumber(9663893014L);
		userRequest.setEmail("update@gmail.com");
		userRequest.setGender(Gender.MALE);
		User user=userService.updateUser(userRequest,2);
		Assertions.assertEquals(user.getEmail(),userRequest.getEmail());
		Assertions.assertEquals(user.getGender(),userRequest.getGender());
		Assertions.assertEquals(user.getNumber(),userRequest.getNumber());

	}

	@Test
	public void createCity(){
		CityRequest cityRequest=new CityRequest();
		cityRequest.setName("Bangalore");
		cityRequest.setLocation("HSR Layout");
		cityRequest.setPincode(560102);
		City city=adminService.createCity(cityRequest);
		Assertions.assertEquals(city.getName(),cityRequest.getName());
		Assertions.assertEquals(city.getPincode(),cityRequest.getPincode());
		Assertions.assertEquals(city.getLocation(),cityRequest.getLocation());
	}

	@Test
	public void createRoom(){
		RoomRequest roomRequest=new RoomRequest();
		roomRequest.setACAvailable(true);
		roomRequest.setNoOfBeds(3);
		Room room=adminService.createRooms(roomRequest);
		Assertions.assertEquals(room.getNoOfBeds(),roomRequest.getNoOfBeds());
		Assertions.assertEquals(room.isACAvailable(),roomRequest.isACAvailable());
	}

	@Test
	public void createHotel(){
		HotelRequest hotelRequest=new HotelRequest();
		hotelRequest.setName("raja hotel");
		hotelRequest.setBedPrice(100);
		hotelRequest.setCityId(1);
		hotelRequest.setHotelOpenToday(true);
		hotelRequest.setWiFiAvailable(true);
		hotelRequest.setFacility1("we will give free tea and coffee");
		Hotel hotel=adminService.createHotel(hotelRequest);
		Assertions.assertEquals(hotel.getName(),hotelRequest.getName());
		Assertions.assertEquals(hotel.getCityId(),hotelRequest.getCityId());
		Assertions.assertEquals(hotel.getBedPrice(),hotelRequest.getBedPrice());
	}
	@Test
	public void updateHotel()throws CustomException{
		HotelRequest hotelRequest=new HotelRequest();
		hotelRequest.setName("update hotel");
		hotelRequest.setBedPrice(100);
		hotelRequest.setCityId(1);
		hotelRequest.setHotelOpenToday(true);
		hotelRequest.setWiFiAvailable(true);
		hotelRequest.setFacility1("updated we will give free tea and coffee");
		Hotel hotel=adminService.updateHotel(hotelRequest,1);
		Assertions.assertEquals(hotel.getName(),hotelRequest.getName());
		Assertions.assertEquals(hotel.getCityId(),hotelRequest.getCityId());
		Assertions.assertEquals(hotel.getBedPrice(),hotelRequest.getBedPrice());
	}

	@Test
	public void createReview()throws CustomException{
		ReviewRequest reviewRequest=new ReviewRequest();
		reviewRequest.setCityId(1);
		reviewRequest.setFeedback("well maintenance");
		reviewRequest.setRating(9);
		reviewRequest.setUserId(2);
		reviewRequest.setHotelId(1);
		Review review=userService.createReview(reviewRequest);
		Assertions.assertEquals(review.getCityId(),reviewRequest.getCityId());
		Assertions.assertEquals(review.getHotelId(),reviewRequest.getHotelId());
		Assertions.assertEquals(review.getRating(),reviewRequest.getRating());
	}

	@Test  //negative test case
	public void searchHotelsByCityIdAndAvailability(){
		Exception exception=Assertions.assertThrows(CustomException.class, ()-> userService.searchByCityIdAndAvailability(100,true));
		String expectedMessage="Given city id is not found";
		String actualMessage=exception.getMessage();

		Assertions.assertEquals(expectedMessage,actualMessage);

	}
	@Test  //positive test case
	public void searchHotelsByCityIdAndAvailabilities()throws CustomException{

		List<Hotel> hotels=userService.searchByCityIdAndAvailability(1,true);
		Assertions.assertEquals(hotels.get(0).getName(),"update hotel");
		Assertions.assertEquals(hotels.get(0).getFacility().getFacility1(),"updated we will give free tea and coffee");
		Assertions.assertEquals(hotels.get(0).getCityId(),1);

	}

	@Test
	public void getAllReviewByGenderAndCityId(){
		List<Review> reviews=userService.getAllReviewsByCityAndGender(1,Gender.MALE);
		Assertions.assertEquals(reviews.get(0).getCityId(),1);
		Assertions.assertEquals(reviews.get(0).getRating(),9);
		Assertions.assertEquals(reviews.get(0).getUserId(),15);
	}
}
