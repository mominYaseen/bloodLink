package com.example.bloodLink.dto;

import com.example.bloodLink.modals.DonationCamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DonationCampResponseDTO {

    private Long id;
    private String campName;
    private String organizerName;
    private String address;
    private String city;
    private String state;
    private String country;
    private Double latitude;
    private Double longitude;
    private LocalDate campDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer totalSlots;
    private LocalDateTime createdAt;
    private String contactNumber;
    private String email;

    public DonationCampResponseDTO(DonationCamp donationCamp) {
        this.id = donationCamp.getId();
        this.campName = donationCamp.getCampName();
        this.organizerName = donationCamp.getOrganizerName();
        this.address = donationCamp.getAddress();
        this.city = donationCamp.getCity();
        this.state = donationCamp.getState();
        this.country = donationCamp.getCountry();
        this.latitude = donationCamp.getLatitude();
        this.longitude = donationCamp.getLongitude();
        this.campDate = donationCamp.getCampDate();
        this.startTime = donationCamp.getStartTime();
        this.endTime = donationCamp.getEndTime();
        this.totalSlots = donationCamp.getTotalSlots();
        this.createdAt = donationCamp.getCreatedAt();
        this.contactNumber = donationCamp.getContactNumber();
        this.email = donationCamp.getEmail();

    }



    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LocalDate getCampDate() {
        return campDate;
    }

    public void setCampDate(LocalDate campDate) {
        this.campDate = campDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Integer getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(Integer totalSlots) {
        this.totalSlots = totalSlots;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
}
