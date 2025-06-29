package com.example.bloodLink.modals;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property ="id"
)
public class BloodInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String bloodGroup;
    private int availableUnits;


    private int minimumUnits;
    @ManyToOne
    @JoinColumn(name = "bloodBankCenterId")
    private BloodBankCenter bloodBankCenter;

    private LocalDateTime lastUpdated;

    private LocalDateTime lastNotifiedAt;







    //constructor
    public BloodInventory() {
    }




    @PrePersist
    protected void onCreate() {
        this.minimumUnits=15;
    }





    // getter and setters
    public Long getId() {
        return id;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }

    public int getMinimumUnits() {
        return minimumUnits;
    }

    public void setMinimumUnits(int minimumUnits) {
        this.minimumUnits = minimumUnits;
    }

    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }

    public BloodBankCenter getBloodBankCenter() {
        return bloodBankCenter;
    }

    public void setBloodBankCenter(BloodBankCenter bloodBankCenter) {
        this.bloodBankCenter = bloodBankCenter;
    }

    public LocalDateTime getLastNotifiedAt() {
        return lastNotifiedAt;
    }

    public void setLastNotifiedAt(LocalDateTime lastNotifiedAt) {
        this.lastNotifiedAt = lastNotifiedAt;
    }

    @Override
    public String toString() {
      return "BloodInventory{id=" + id + ", bloodGroup=" + bloodGroup + ", availableUnits=" + availableUnits
          + ", minimumUnits=" + minimumUnits + ", bloodBankCenter=" + bloodBankCenter + ", lastUpdated=" + lastUpdated
          + ", lastNotifiedAt=" + lastNotifiedAt + ", getId()=" + getId() + ", getLastUpdated()=" + getLastUpdated()
          + ", getBloodGroup()=" + getBloodGroup() + ", getAvailableUnits()=" + getAvailableUnits()
          + ", getMinimumUnits()=" + getMinimumUnits() + ", getBloodBankCenter()=" + getBloodBankCenter()
          + ", getLastNotifiedAt()=" + getLastNotifiedAt() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
          + ", toString()=" + super.toString() + "}";
    }
}
