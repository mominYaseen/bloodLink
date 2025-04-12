package com.example.bloodLink.service;

import com.example.bloodLink.modals.DonationCamp;

import java.util.List;

public interface DonationCampService {
    List<DonationCamp> findByIsApprovedFalse();

}
