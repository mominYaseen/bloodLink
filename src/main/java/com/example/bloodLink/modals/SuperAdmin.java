package com.example.bloodLink.modals;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "superAdminTable")
@Data
public class SuperAdmin {
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
    @Column(name = "phoneNumber",unique = true,nullable = false)
    private String phoneNumber;

    @Column(name = "role")
    private String role = "SUPER_ADMIN";
}
