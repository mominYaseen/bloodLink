package com.example.bloodLink.modals;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "bloodBankCenter")
public class BloodBankCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String contactNumber;
    private String email;

    private String city;
    private String state;
    private String country;

    private double latitude;
    private double longitude;

    @CreationTimestamp
    private LocalDateTime createdAt;


    @OneToOne(mappedBy = "bloodBankCenter")
    private SubAdmin subAdmin;


//    @OneToMany(mappedBy = "bloodBankCenter", cascade = CascadeType.ALL)
//    private List<BloodInventory> bloodInventories = new ArrayList<>();
//
//    @OneToMany(mappedBy = "bloodBankCenter", cascade = CascadeType.ALL)
//    private List<BloodInventoryLog> inventoryLogs = new ArrayList<>();


    // constructor

    public BloodBankCenter() {

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

//    public List<BloodInventory> getBloodInventories() {
//        return bloodInventories;
//    }
//
//    public void setBloodInventories(List<BloodInventory> bloodInventories) {
//        this.bloodInventories = bloodInventories;
//    }
//
//    public List<BloodInventoryLog> getInventoryLogs() {
//        return inventoryLogs;
//    }
//
//    public void setInventoryLogs(List<BloodInventoryLog> inventoryLogs) {
//        this.inventoryLogs = inventoryLogs;
//    }
}
