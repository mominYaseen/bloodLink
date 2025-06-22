package com.example.bloodLink.modals;

import com.example.bloodLink.dto.SubAdminResponseDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "bloodBankCenter")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property ="id"
)
public class BloodBankCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(unique = true,nullable = false)
    private String contactNumber;
    @Column(unique = true,nullable = false)
    private String email;

    private String city;
    private String state;
    private String country;

    private double latitude;
    private double longitude;

    private int centerEstablishedTime;

    @CreationTimestamp
    private LocalDateTime accountCreatedAt;


    @OneToOne(mappedBy = "bloodBankCenter")
    private SubAdmin subAdmin;


    @JsonIgnore
    @OneToMany(mappedBy = "bloodBankCenter",cascade = CascadeType.ALL)
    private List<DonationCamp> donationCamps = new ArrayList<>();



    @OneToMany(mappedBy = "bloodBankCenter", cascade = CascadeType.ALL)
    private List<BloodInventory> bloodInventories = new ArrayList<>();

    @OneToMany(mappedBy = "bloodBankCenter", cascade = CascadeType.ALL)
    private List<BloodInventoryLog> inventoryLogs = new ArrayList<>();


    // constructor

    public BloodBankCenter() {

    }


    // getter and setters


    public List<DonationCamp> getDonationCamps() {
        return donationCamps;
    }

    public void setDonationCamps(List<DonationCamp> donationCamps) {
        this.donationCamps = donationCamps;
    }

    public SubAdminResponseDTO getSubAdmin() {
        return new SubAdminResponseDTO(subAdmin);
    }

    public void setSubAdmin(SubAdmin subAdmin) {
        this.subAdmin = subAdmin;
    }

    public List<BloodInventory> getBloodInventories() {
        return bloodInventories;
    }

    public void setBloodInventories(List<BloodInventory> bloodInventories) {
        this.bloodInventories = bloodInventories;
    }

    public List<BloodInventoryLog> getInventoryLogs() {
        return inventoryLogs;
    }

    public void setInventoryLogs(List<BloodInventoryLog> inventoryLogs) {
        this.inventoryLogs = inventoryLogs;
    }

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

    public LocalDateTime getAccountCreatedAt() {
        return accountCreatedAt;
    }

    public int getCenterEstablishedTime() {
        return centerEstablishedTime;
    }

    public void setCenterEstablishedTime(int centerEstablishedTime) {
        this.centerEstablishedTime = centerEstablishedTime;
    }

    public void setAccountCreatedAt(LocalDateTime accountCreatedAt) {
        this.accountCreatedAt = accountCreatedAt;
    }


//
//    public List<BloodInventoryLog> getInventoryLogs() {
//        return inventoryLogs;
//    }
//
//    public void setInventoryLogs(List<BloodInventoryLog> inventoryLogs) {
//        this.inventoryLogs = inventoryLogs;
//    }
}
