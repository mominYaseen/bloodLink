package com.example.bloodLink.dto;

public class EligibilityCheckResponse {

  private boolean checkDone;
private boolean eligibleToDonate;








  public EligibilityCheckResponse(boolean checkDone,boolean eligibleToDonate) {
    this.checkDone = checkDone;
    this.eligibleToDonate = eligibleToDonate;
  }

  public boolean isCheckDone() {
    return checkDone;
  }

  public void setCheckDone(boolean checkDone) {
    this.checkDone = checkDone;
  }

  public boolean isEligibleToDonate() {
    return eligibleToDonate;
  }

  public void setEligibleToDonate(boolean eligibleToDonate) {
    this.eligibleToDonate = eligibleToDonate;
  }


  
}
