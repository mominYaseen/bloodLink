package com.example.bloodLink.dto;

public class BloodInventoryLogDTO{
    private String bloodGroup;
    private int quantityChanged; // Positive for addition, negative for deduction
    private String actionType;   // e.g., "DONATION", "REQUEST", "MANUAL_ADJUSTMENT"
    private String remarks;
//    private String performedBy;





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

//    public String getPerformedBy() {
//        return performedBy;
//    }
//
//    public void setPerformedBy(String performedBy) {
//        this.performedBy = performedBy;
//    }
}
