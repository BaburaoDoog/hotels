# hotels
in this task i have used java-8, Spring boot, mysql, Junit, Spring data-JPA,


1) src/test/java/com/hotel/booking/BookingApplicationTests.java
        in this path i have written all the test cases
        
2)src/main/java/com/hotel/booking/BookingApplication.java
        go to this path and run the spring boot application
        
        
        1)http://localhost:8081/admin/createHotel. this api will create the hotel and response body pasted below link.
        <img width="435" alt="Screenshot 2022-10-05 at 3 42 34 PM" src="https://user-images.githubusercontent.com/102274365/194037413-9b35f353-cf23-47d5-9972-8b3dd2fa6f7d.png">
        
        2)http://localhost:8081/admin/createNewCity.  using this api create the new city response body pasted below link.
        <img width="434" alt="Screenshot 2022-10-05 at 3 48 59 PM" src="https://user-images.githubusercontent.com/102274365/194038192-883dad4b-c3a3-4483-9e8b-7398ee212ad8.png">
        
        3)http://localhost:8081/admin/updateHotel/{hotelId}. using this api we can update the hotels.
        
        <img width="428" alt="Screenshot 2022-10-05 at 3 52 26 PM" src="https://user-images.githubusercontent.com/102274365/194038838-ac0cc4be-456d-4ff0-89c9-dc61d8d9bc98.png">

         4)http://localhost:8081/admin/deleteHotel/{id}.    using this api we can delete the hotel
         
         5)http://localhost:8081/user/createUser.  using this api we can create the new User and response body pasted below.
         
              {
                "id": 27,
                "firstName": "Baburao",
                "lastName": "Doog",
                "email": "baburao@gmail.com",
                "number": 9663893014,
                "gender": "MALE",
                "createdOn": 2022-10-05 10:37:00.10,
                "updatedOn": null
              }

            6)http://localhost:8081/user/updateUser/{id}.   USING THIS API WE CAN UPDATE the user and response body pasted below.
             {
                "id": 27,
                "firstName": "update Baburao",
                "lastName": "update Doog",
                "email": "baburao@gmail.com",
                "number": 9663893014,
                "gender": "MALE",
                "createdOn": 2022-10-05 10:37:00.10,
                "updatedOn": 2022-10-05 11:30:00.50
              }
              
              7) http://localhost:8081/user/createReview.  using this api we can create the review   (User only one time can give the feedback of each hotels)  and response body pasted below.
              
              <img width="1014" alt="Screenshot 2022-10-05 at 4 12 30 PM" src="https://user-images.githubusercontent.com/102274365/194042425-927fc8be-bb27-49e2-9649-f783baec75ac.png">


               8) http://localhost:8081/user/getAllReviews/{cityId}/{gender}.  using this api we can get all the reviews by cityId and gender  and response body pasted below.
               
               <img width="386" alt="Screenshot 2022-10-05 at 4 17 02 PM" src="https://user-images.githubusercontent.com/102274365/194043188-b139d4ee-fadf-473a-9d4d-686fa51f48b8.png">


                9)http://localhost:8081/user/searchHotels/cityId/{cityId}/availability/{availability}
                <img width="408" alt="Screenshot 2022-10-05 at 4 18 42 PM" src="https://user-images.githubusercontent.com/102274365/194043452-32e4fddf-842f-48da-9a78-abcfc2e100a4.png">
                
                10))http://localhost:8081user/deleteReview/{id}.  using this api user can delete the his feedback
