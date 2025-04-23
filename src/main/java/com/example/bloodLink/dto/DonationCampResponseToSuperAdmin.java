package com.example.bloodLink.dto;

import com.example.bloodLink.modals.DonationCamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DonationCampResponseToSuperAdmin {

    private Long id;
    private String campName;
    private String organizerName;
    private String address;
    private String city;
    private String state;
    private String country;
    private double latitude;
    private double longitude;
    private LocalDate campDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private int totalSlots;
    private int slotsBooked;
    private int slotsLeft;
    private LocalDateTime createdAt;
    private String contactNumber;
    private String email;
    private String bloodBankCenterName;
    private boolean active;
    private boolean approved;

    public DonationCampResponseToSuperAdmin(DonationCamp camp) {
        this.id = camp.getId();
        this.campName = camp.getCampName();
        this.organizerName = camp.getOrganizerName();
        this.address = camp.getAddress();
        this.city = camp.getCity();
        this.state = camp.getState();
        this.country = camp.getCountry();
        this.latitude = camp.getLatitude();
        this.longitude = camp.getLongitude();
        this.campDate = camp.getCampDate();
        this.startTime = camp.getStartTime();
        this.endTime = camp.getEndTime();
        this.totalSlots = camp.getTotalSlots();
        this.slotsBooked = camp.getSlotsBooked();
        this.slotsLeft = camp.getSlotsLeft();
        this.createdAt = camp.getCreatedAt();
        this.contactNumber = camp.getContactNumber();
        this.email = camp.getEmail();
        this.bloodBankCenterName = camp.getBloodBankCenter() != null ? camp.getBloodBankCenter().getName() : null;
        this.active = camp.isActive();
        this.approved = camp.isApproved();
    }

















    // Getters and setters

    public int getSlotsLeft() {
        return slotsLeft;
    }

    public void setSlotsLeft(int slotsLeft) {
        this.slotsLeft = slotsLeft;
    }

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

    public int getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public int getSlotsBooked() {
        return slotsBooked;
    }

    public void setSlotsBooked(int slotsBooked) {
        this.slotsBooked = slotsBooked;
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

    public String getBloodBankCenterName() {
        return bloodBankCenterName;
    }

    public void setBloodBankCenterName(String bloodBankCenterName) {
        this.bloodBankCenterName = bloodBankCenterName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
