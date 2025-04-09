package com.example.bloodLink.modals;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "adminTable")
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

//    @Column(name = "role")
//    private String role = "ADMIN";

    public Admin() {
    }

    public Admin(String firstName, String lastName, String email, String password, String phoneNumber, String assignedHospital, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.assignedHospital = assignedHospital;
//        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAssignedHospital() {
        return assignedHospital;
    }

    public void setAssignedHospital(String assignedHospital) {
        this.assignedHospital = assignedHospital;
    }

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", assignedHospital='" + assignedHospital + '\'' +
//                ", role='" + role + '\'' +
                '}';
    }
}
