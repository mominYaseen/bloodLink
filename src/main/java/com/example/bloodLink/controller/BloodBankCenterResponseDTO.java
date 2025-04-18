package com.example.bloodLink.controller;

import com.example.bloodLink.modals.BloodBankCenter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class BloodBankCenterResponseDTO {

    private Long id;
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    private String city;
    private String state;
    private String country;
    private String subAdminEmail;

    public BloodBankCenterResponseDTO(BloodBankCenter bloodBankCenter) {
        this.id = bloodBankCenter.getId();
        this.name = bloodBankCenter.getName();
        this.address = bloodBankCenter.getAddress();
        this.contactNumber = bloodBankCenter.getContactNumber();
        this.email = bloodBankCenter.getEmail();
        this.city = bloodBankCenter.getCity();
        this.state = bloodBankCenter.getState();
        this.country = bloodBankCenter.getCountry();
        this.subAdminEmail = (bloodBankCenter.getSubAdmin() != null)
                ? bloodBankCenter.getSubAdmin().getEmail()
                : null;
    }


    // getter and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSubAdminEmail() {
        return subAdminEmail;
    }

    public void setSubAdminEmail(String subAdminEmail) {
        this.subAdminEmail = subAdminEmail;
    }
}
