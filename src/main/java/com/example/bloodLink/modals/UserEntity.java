package com.example.bloodLink.modals;

import com.example.bloodLink.enums.GenderEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "userTable")

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
//    private String password;
    @Column(name = "phoneNumber",nullable = false,unique = true)
    private String phoneNumber;

    @Column(name = "gender" , nullable = false)
    private String  gender;

    @Column(name = "age")
    private int age;

    @Column(name = "bloodGroup")
    private String bloodGroup;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

    @CreationTimestamp
    @Column(name = "accountCreatedDate")
    private LocalDateTime createdAt;

    @Column(name = "eligibleToDonate")
    private boolean eligibleToDonate;
    @Column(name = "lastDonationDate")
    private LocalDate LastDonatedDate;
    @Column(name = "nextDonationDate")
    private LocalDate nextDonationDate;

    private boolean eligibilityCheckDone;// don't need to send in json


    @JsonIgnore
    @ManyToMany(mappedBy = "registeredDonors")
    private List<DonationCamp> registeredCamps = new ArrayList<>();


    // constructor


    public UserEntity() {
    }


    @PrePersist
    protected  void onCreate(){
        this.eligibleToDonate=false;
        this.eligibilityCheckDone=false;
        this.registeredCamps=null;
        this.createdAt=LocalDateTime.now();
    }


    //setters and getters


    public List<DonationCamp> getRegisteredCamps() {
        return registeredCamps;
    }

    public void setRegisteredCamps(List<DonationCamp> registeredCamps) {
        this.registeredCamps = registeredCamps;
    }

    public boolean isEligibilityCheckDone() {
        return eligibilityCheckDone;
    }

    public void setEligibilityCheckDone(boolean eligibilityCheckDone) {
        this.eligibilityCheckDone = eligibilityCheckDone;
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

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isEligibleToDonate() {
        return eligibleToDonate;
    }

    public void setEligibleToDonate(boolean eligibleToDonate) {
        this.eligibleToDonate = eligibleToDonate;
    }

    public LocalDate getLastDonatedDate() {
        return LastDonatedDate;
    }

    public void setLastDonatedDate(LocalDate lastDonatedDate) {
        LastDonatedDate = lastDonatedDate;
    }

    public LocalDate getNextDonationDate() {
        return nextDonationDate;
    }

    public void setNextDonationDate(LocalDate nextDonationDate) {
        this.nextDonationDate = nextDonationDate;
    }


    @Override
    public String toString() {
      return "UserEntity{id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
          + ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", age=" + age + ", bloodGroup=" + bloodGroup
          + ", address=" + address + ", city=" + city + ", state=" + state + "}";
    }



}
