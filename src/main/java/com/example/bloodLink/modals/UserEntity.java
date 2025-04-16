package com.example.bloodLink.modals;

import com.example.bloodLink.enums.GenderEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "userTable")

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    private String password;
    @Column(name = "phoneNumber",nullable = false,unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender" , nullable = false)
    private GenderEnum gender;

    @Column(name = "age")
    private int age;

    @Column(name = "bloodGroup")
    private String bloodGroup;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

    @CreationTimestamp
    @Column(name = "accountCreatedDate")
    private LocalDateTime createdAt;

    @Column(name = "eligibleToDonate")
    private boolean eligibleToDonate;
    @Column(name = "lastDonationDate")
    private LocalDateTime LastDonatedDate;
    @Column(name = "nextDonationDate")
    private LocalDateTime nextDonationDate;
}
