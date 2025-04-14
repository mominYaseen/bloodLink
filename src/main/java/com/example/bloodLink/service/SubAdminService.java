package com.example.bloodLink.service;

import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.modals.SubAdmin;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface SubAdminService extends UserDetailsService {

    // request for opening blood donation camp
    DonationCamp reqDonationCamp(DonationCamp camp);
    SubAdmin loadUserByUsername(String email);
}
