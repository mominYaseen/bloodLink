package com.example.bloodLink.dto;

import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.BloodInventory;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class BloodInventoryResponseDto {




    private String bloodGroup;
    private int availableUnits;
    private LocalDateTime lastUpdated;


    public BloodInventoryResponseDto(BloodInventory bloodInventory) {
        this.bloodGroup = bloodInventory.getBloodGroup();
        this.availableUnits = bloodInventory.getAvailableUnits();
        this.lastUpdated = bloodInventory.getLastUpdated();


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

    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
