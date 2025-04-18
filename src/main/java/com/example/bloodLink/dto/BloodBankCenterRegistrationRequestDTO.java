package com.example.bloodLink.dto;

import java.time.LocalDateTime;
import java.util.List;

public class BloodBankCenterRegistrationRequestDTO {
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    private String city;
    private String state;
    private String country;
    private double latitude;
    private double longitude;
    private LocalDateTime centerEstablishedTime;

    private List<BloodInventoryDTO> bloodInventories;


    // Getters and Setters

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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getCenterEstablishedTime() {
        return centerEstablishedTime;
    }

    public void setCenterEstablishedTime(LocalDateTime centerEstablishedTime) {
        this.centerEstablishedTime = centerEstablishedTime;
    }

    public List<BloodInventoryDTO> getBloodInventories() {
        return bloodInventories;
    }

    public void setBloodInventories(List<BloodInventoryDTO> bloodInventories) {
        this.bloodInventories = bloodInventories;
    }
}