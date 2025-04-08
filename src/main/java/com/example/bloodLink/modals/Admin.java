package com.example.bloodLink.modals;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "adminTable")
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phoneNumber",nullable = false,unique = true)
    private String phoneNumber;

    @Column(name="assignedHospital")
    private String assignedHospital; // Optional: if managing specific blood bank/hospital

    @Column(name = "role")
    private String role = "ADMIN";
}
