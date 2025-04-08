package com.example.bloodLink.dto;

import com.example.bloodLink.enums.GenderEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserEntityDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private GenderEnum gender;
    private int age;
    private String bloodGroup;
    private String address;
    private String city;
    private String state;
    private String country;
    private double latitude;
    private double longitude;

    private boolean eligibleToDonate;
    private LocalDateTime donatedDate;
    private LocalDateTime nextDonationDate;
    private LocalDateTime createdAt;
}
