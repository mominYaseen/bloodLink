package com.example.bloodLink.dto;

import com.example.bloodLink.modals.BloodInventory;

public class BloodShortageResponse {
    private String centerName;
    private String city;
    private String bloodGroup;
    private int availableUnits;


    public BloodShortageResponse(BloodInventory bloodInventory) {
        this.centerName = bloodInventory.getBloodBankCenter().getName();
        this.city = bloodInventory.getBloodBankCenter().getCity();
        this.bloodGroup = bloodInventory.getBloodGroup();
        this.availableUnits = bloodInventory.getAvailableUnits();
    }


    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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


    @Override
    public String toString() {
      return "BloodShortageResponse{centerName=" + centerName + ", city=" + city + ", bloodGroup=" + bloodGroup
          + ", availableUnits=" + availableUnits + ", getCenterName()=" + getCenterName() + ", getCity()=" + getCity()
          + ", getBloodGroup()=" + getBloodGroup() + ", getAvailableUnits()=" + getAvailableUnits() + ", getClass()="
          + getClass() + "}";
    }
}
