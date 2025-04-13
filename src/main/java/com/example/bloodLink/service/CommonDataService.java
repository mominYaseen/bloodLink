package com.example.bloodLink.service;

import com.example.bloodLink.modals.DonationCamp;

import java.util.List;

public interface CommonDataService {

    //get all donation camps that are not yet approved (for super admin)
    List<DonationCamp> getAllNonApprovedListOfDonationCamps();

    // approve/activate donationCamp (for super admin)
    DonationCamp approveDonationCamp(Long campId);
}
