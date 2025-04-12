package com.example.bloodLink.dto;


import com.example.bloodLink.modals.SubAdmin;

import java.time.LocalDateTime;

public class SubAdminDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String assignedHospital;
    private String role;
    private LocalDateTime createdAt;

    public SubAdminDTO() {
    }

    public SubAdminDTO(SubAdmin admin) {
        this.firstName = admin.getFirstName();
        this.lastName = admin.getLastName();
        this.email = admin.getEmail();
        this.phoneNumber = admin.getPhoneNumber();
        this.assignedHospital = admin.getAssignedHospital();
        this.role = admin.getRole();
        this.createdAt = admin.getCreatedAt();
    }

    // Getters and Setters

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

    public String getAssignedHospital() {
        return assignedHospital;
    }

    public void setAssignedHospital(String assignedHospital) {
        this.assignedHospital = assignedHospital;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

