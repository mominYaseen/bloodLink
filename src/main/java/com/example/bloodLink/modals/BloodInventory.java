package com.example.bloodLink.modals;

import jakarta.persistence.*;

public class BloodInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bloodGroup;
    private int availableUnits;

//    @ManyToOne
//    @JoinColumn(name = "hospital_center_id")
//    private BloodBankCenter bloodBankCenter;

    //constructor


    public BloodInventory() {
    }

    // getter and setters
    public Long getId() {
        return id;
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

    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }

//    public BloodBankCenter getBloodBankCenter() {
//        return bloodBankCenter;
//    }
//
//    public void setBloodBankCenter(BloodBankCenter bloodBankCenter) {
//        this.bloodBankCenter = bloodBankCenter;
//    }
}
