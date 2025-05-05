package com.example.bloodLink.dto;


import com.example.bloodLink.modals.SubAdmin;

import java.time.LocalDateTime;

public class SubAdminCreateDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String assignedBloodBankCenterName;
//    private String role;
    private String password;


    private LocalDateTime createdAt;

    public SubAdminCreateDTO() {
    }


    public SubAdminCreateDTO(SubAdmin admin) {
        this.firstName = admin.getFirstName();
        this.lastName = admin.getLastName();
        this.email = admin.getEmail();
        this.phoneNumber = admin.getPhoneNumber();
        this.assignedBloodBankCenterName = admin.getAssignedBloodBankCenter();
//        this.role = admin.getRole();
//        this.createdAt = admin.getCreatedAt();
    }

    // Getters and Setters

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAssignedBloodBankCenterName() {
        return assignedBloodBankCenterName;
    }

    public void setAssignedBloodBankCenterName(String assignedBloodBankCenterName) {
        this.assignedBloodBankCenterName = assignedBloodBankCenterName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }

//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
}

