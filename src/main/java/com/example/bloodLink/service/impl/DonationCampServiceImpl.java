package com.example.bloodLink.service.impl;

import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.repository.DonationCampRepo;
import com.example.bloodLink.service.DonationCampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationCampServiceImpl implements DonationCampService {

    @Autowired
    private DonationCampRepo donationCampRepo;

    @Override
    public List<DonationCamp> findByIsApprovedFalse() {
        return donationCampRepo.findByIsApprovedFalse();
    }

    @Override
    public DonationCamp approveDonationCamp(Long campId) {
        DonationCamp donationCamp = donationCampRepo.findById(campId)
                .orElseThrow(()->new RuntimeException("DONATION CAMP NOT FOUND"));
        // approving the donation camp
        donationCamp.setApproved(true);

        //persisting the changes in the DB
       return donationCampRepo.save(donationCamp);
    }
}
