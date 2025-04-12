package com.example.bloodLink.service.impl;

import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.repository.DonationCampRepo;
import com.example.bloodLink.service.DonationCampService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DonationCampServiceImpl implements DonationCampService {

    @Autowired
    private DonationCampRepo donationCampRepo;

    @Override
    public List<DonationCamp> findByIsApprovedFalse() {
        return donationCampRepo.findByIsApprovedFalse();
    }
}
