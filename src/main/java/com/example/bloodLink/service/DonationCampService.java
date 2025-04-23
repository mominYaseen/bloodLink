package com.example.bloodLink.service;

import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.DonationCamp;

import java.util.List;

public interface DonationCampService {
    List<DonationCamp> findByIsApprovedFalse();
    DonationCamp approveDonationCamp(Long campId);
    List<DonationCamp> findByIsApprovedTrue();
    List<DonationCamp> findByIsActiveTrue();
    DonationCamp reqDonationCamp(DonationCamp camp);
    List<DonationCamp> findByIsApprovedFalseAndBloodBankCenter(BloodBankCenter bloodBankCenter);
    List<DonationCamp> findByIsActiveTrueAndBloodBankCenter(BloodBankCenter bloodBankCenter);
    String registerForDonationCamp(String donorEmail , Long campId);

}
