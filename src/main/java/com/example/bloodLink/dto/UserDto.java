package com.example.bloodLink.dto;

import com.example.bloodLink.enums.GenderEnum;
import com.example.bloodLink.modals.UserEntity;
import org.apache.catalina.User;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String gender;
    private int age;
    private String bloodGroup;
    private String address;
    private String city;
    private String state;
    private String country;
    private double latitude;
    private double longitude;
    private LocalDateTime lastDonationDate;






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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getBloodGroup() {
        return bloodGroup;
    }
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
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
//    public boolean isEligibleToDonate() {
//        return eligibleToDonate;
//    }
//    public void setEligibleToDonate(boolean eligibleToDonate) {
//        this.eligibleToDonate = eligibleToDonate;
//    }
    public LocalDateTime getLastDonationDate() {
        return lastDonationDate;
    }
    public void setLastDonationDate(LocalDateTime lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }
}
