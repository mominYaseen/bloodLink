package com.example.bloodLink.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class EligibilityFormDTO {
    private boolean feelingWell;
    private boolean recentDonation;
    private boolean takingMedication;
    private boolean hasChronicIllness;
    private boolean hasInfection;
    private boolean covidRecently;
    private boolean malariaTravel;
    private boolean hasTattoo;
    private boolean testedPositiveHIV;
    private boolean pregnant;
    private int weight;

    public EligibilityFormDTO() {
    }

    public EligibilityFormDTO(boolean feelingWell, boolean recentDonation, boolean takingMedication, boolean hasChronicIllness, boolean hasInfection, boolean covidRecently, boolean malariaTravel, boolean hasTattoo, boolean testedPositiveHIV, boolean pregnant, int weight) {
        this.feelingWell = feelingWell;
        this.recentDonation = recentDonation;
        this.takingMedication = takingMedication;
        this.hasChronicIllness = hasChronicIllness;
        this.hasInfection = hasInfection;
        this.covidRecently = covidRecently;
        this.malariaTravel = malariaTravel;
        this.hasTattoo = hasTattoo;
        this.testedPositiveHIV = testedPositiveHIV;
        this.pregnant = pregnant;
        this.weight = weight;
    }

    public boolean isFeelingWell() {
        return feelingWell;
    }

    public void setFeelingWell(boolean feelingWell) {
        this.feelingWell = feelingWell;
    }

    public boolean isRecentDonation() {
        return recentDonation;
    }

    public void setRecentDonation(boolean recentDonation) {
        this.recentDonation = recentDonation;
    }

    public boolean isTakingMedication() {
        return takingMedication;
    }

    public void setTakingMedication(boolean takingMedication) {
        this.takingMedication = takingMedication;
    }

    public boolean isHasChronicIllness() {
        return hasChronicIllness;
    }

    public void setHasChronicIllness(boolean hasChronicIllness) {
        this.hasChronicIllness = hasChronicIllness;
    }

    public boolean isHasInfection() {
        return hasInfection;
    }

    public void setHasInfection(boolean hasInfection) {
        this.hasInfection = hasInfection;
    }

    public boolean isCovidRecently() {
        return covidRecently;
    }

    public void setCovidRecently(boolean covidRecently) {
        this.covidRecently = covidRecently;
    }

    public boolean isMalariaTravel() {
        return malariaTravel;
    }

    public void setMalariaTravel(boolean malariaTravel) {
        this.malariaTravel = malariaTravel;
    }

    public boolean isHasTattoo() {
        return hasTattoo;
    }

    public void setHasTattoo(boolean hasTattoo) {
        this.hasTattoo = hasTattoo;
    }

    public boolean isTestedPositiveHIV() {
        return testedPositiveHIV;
    }

    public void setTestedPositiveHIV(boolean testedPositiveHIV) {
        this.testedPositiveHIV = testedPositiveHIV;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EligibilityFormDTO{" +
                "feelingWell=" + feelingWell +
                ", recentDonation=" + recentDonation +
                ", takingMedication=" + takingMedication +
                ", hasChronicIllness=" + hasChronicIllness +
                ", hasInfection=" + hasInfection +
                ", covidRecently=" + covidRecently +
                ", malariaTravel=" + malariaTravel +
                ", hasTattoo=" + hasTattoo +
                ", testedPositiveHIV=" + testedPositiveHIV +
                ", pregnant=" + pregnant +
                ", weight=" + weight +
                '}';
    }
}

