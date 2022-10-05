package com.hotel.booking.Entity;

import com.hotel.booking.Enums.Gender;
import com.hotel.booking.Requests.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private long number;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(updatable = false,insertable = true)
    private Date createdOn;
    @Column(updatable = true,insertable = false)
    private Date updatedOn;



     public User(UserRequest userRequest) {
        this.firstName = userRequest.getFirstName();
        this.lastName = userRequest.getLastName();
        this.email = userRequest.getEmail();
        this.number = userRequest.getNumber();
        this.gender = userRequest.getGender();
        this.createdOn = userRequest.getCreatedOn();
    }


}
