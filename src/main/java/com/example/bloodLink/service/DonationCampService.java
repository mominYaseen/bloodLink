package com.example.bloodLink.service;

import com.example.bloodLink.modals.DonationCamp;

import java.util.List;

public interface DonationCampService {
    List<DonationCamp> findByIsApprovedFalse();
    DonationCamp approveDonationCamp(Long campId);
    List<DonationCamp> findByIsApprovedTrue();
    List<DonationCamp> findByIsActiveTrue();
    DonationCamp reqDonationCamp(DonationCamp camp);

}
