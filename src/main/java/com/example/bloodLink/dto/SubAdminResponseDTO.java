package com.example.bloodLink.dto;

import com.example.bloodLink.modals.SubAdmin;

import java.time.LocalDateTime;

public class SubAdminResponseDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String assignedBloodBankCenterName;
    private String role;
    private LocalDateTime createdAt;

    public SubAdminResponseDTO(SubAdmin subAdmin) {
        this.firstName= subAdmin.getFirstName();
        this.lastName = subAdmin.getLastName();
        this.email = subAdmin.getEmail();
        this.phoneNumber = subAdmin.getPhoneNumber();
        this.assignedBloodBankCenterName = subAdmin.getPhoneNumber();
        this.role = subAdmin.getRole();
        this.createdAt = subAdmin.getCreatedAt();
    }


    // getter and setters

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
/*
* this dto is used in returning the response , as in the previous response , the password of subAdmin was being shown to the
* super admin.
*
* */