package com.example.bloodLink.modals;


import com.example.bloodLink.dto.SubAdminCreateDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "donation_camps")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property ="id"
)
public class DonationCamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String campName;
    @Column(unique = true)
    private String organizerName;

    private String address; // from frontend using js
    private String city; // from frontend using js
    private String state; // from frontend using js
    private String country; // from frontend using js

    private double latitude; // from frontend using js
    private double longitude; // from frontend using js

    private LocalDate campDate;
    private LocalTime startTime;
    private LocalTime endTime;

    private int totalSlots;
    private int slotsBooked;
    private int slotsLeft;
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(unique = true)
    private String contactNumber;

    @Column(unique = true)

    private String email;

    private boolean isApproved ;

    private boolean isActive;


    @ManyToOne
    @JoinColumn(name = "sub_admin", referencedColumnName = "id",nullable = false)
    private SubAdmin subAdmin;


    public DonationCamp() {
    }


    @PrePersist
    protected void onCreate() {
        this.slotsBooked = 0;
        this.slotsLeft=0;
        this.isActive=false;
        this.isApproved = false;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public SubAdminCreateDTO getSubAdmin() {
        return new SubAdminCreateDTO(subAdmin);
    }

    public void setSubAdmin(SubAdmin subAdmin) {
        this.subAdmin = subAdmin;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCampName() { return campName; }
    public void setCampName(String campName) { this.campName = campName; }

    public String getOrganizerName() { return organizerName; }
    public void setOrganizerName(String organizerName) { this.organizerName = organizerName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public LocalDate getCampDate() { return campDate; }
    public void setCampDate(LocalDate campDate) { this.campDate = campDate; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public int getTotalSlots() { return totalSlots; }
    public void setTotalSlots(int totalSlots) { this.totalSlots = totalSlots; }

    public int getSlotsBooked() { return slotsBooked; }
    public void setSlotsBooked(int slotsBooked) { this.slotsBooked = slotsBooked; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getSlotsLeft() {
        return slotsLeft;
    }

    public void setSlotsLeft(int slotsLeft) {
        this.slotsLeft = slotsLeft;
    }
}
