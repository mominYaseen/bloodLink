package com.example.bloodLink.service;

import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.modals.SubAdmin;

public interface SubAdminService {

    // request for opening blood donation camp
    DonationCamp reqDonationCamp(DonationCamp camp);
    SubAdmin findByEmail(String email);
}
