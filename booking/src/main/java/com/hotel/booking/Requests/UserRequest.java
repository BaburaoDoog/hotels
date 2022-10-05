package com.hotel.booking.Requests;

import com.hotel.booking.Enums.Gender;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
public class UserRequest {

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
}
