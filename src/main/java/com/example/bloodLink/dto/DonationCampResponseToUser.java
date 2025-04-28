package com.example.bloodLink.dto;

import com.example.bloodLink.modals.DonationCamp;

import java.time.LocalDate;

public class DonationCampResponseToUser {
    private String campName;
    private String organizerName;
    private String address;
    private String city;
    private String state;
    private String country;
    private LocalDate campDate;
    private String contactNumber;
    private String email;

    public DonationCampResponseToUser(DonationCamp camp) {
        this.campName = camp.getCampName();
        this.organizerName = camp.getOrganizerName();
        this.address = camp.getAddress();
        this.city = camp.getCity();
        this.state = camp.getState();
        this.country = camp.getCountry();
        this.campDate = camp.getCampDate();
        this.contactNumber = camp.getContactNumber();
        this.email = camp.getEmail();
    }



    // getter and setter

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

    public LocalDate getCampDate() {
        return campDate;
    }

    public void setCampDate(LocalDate campDate) {
        this.campDate = campDate;
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
