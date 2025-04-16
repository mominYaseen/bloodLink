package com.example.bloodLink.modals;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class BloodInventoryLog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bloodGroup;
    private int quantityChanged; // Positive for addition, negative for deduction
    private String actionType;   // e.g., "DONATION", "REQUEST", "MANUAL_ADJUSTMENT"
    private String remarks;
    private String performedBy;

    private LocalDateTime actionTime;

//    @ManyToOne
//    @JoinColumn(name = "bloodBankCenterId")
//    private BloodBankCenter bloodBankCenter;

    @PrePersist
    protected void onCreate() {
        this.actionTime = LocalDateTime.now();
    }

    //constructor
    public BloodInventoryLog() {

    }


    //getter and setters

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

    public int getQuantityChanged() {
        return quantityChanged;
    }

    public void setQuantityChanged(int quantityChanged) {
        this.quantityChanged = quantityChanged;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }

    public LocalDateTime getActionTime() {
        return actionTime;
    }

    public void setActionTime(LocalDateTime actionTime) {
        this.actionTime = actionTime;
    }

//    public BloodBankCenter getBloodBankCenter() {
//        return bloodBankCenter;
//    }
//
//    public void setBloodBankCenter(BloodBankCenter bloodBankCenter) {
//        this.bloodBankCenter = bloodBankCenter;
//    }
}