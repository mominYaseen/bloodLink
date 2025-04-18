package com.example.bloodLink.dto;

// DTO: BloodInventoryDTO.java
public class BloodInventoryDTO {
    private String bloodGroup;
    private int availableUnits;
    private int minimumUnits;

    // Getters and Setters

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

    public int getMinimumUnits() {
        return minimumUnits;
    }

    public void setMinimumUnits(int minimumUnits) {
        this.minimumUnits = minimumUnits;
    }
}