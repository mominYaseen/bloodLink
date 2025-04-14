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

    // method for requesting donation camp
    @Override
    public DonationCamp reqDonationCamp(DonationCamp camp) {

        return donationCampRepo.save(camp);
    }


    // getting list of donation camp that are not yet approved by the super admin
    @Override
    public List<DonationCamp> findByIsApprovedFalse() {
        return donationCampRepo.findByIsApprovedFalse();
    }


    // approving the donation camp (done by super admin)
    @Override
    public DonationCamp approveDonationCamp(Long campId) {
        DonationCamp donationCamp = donationCampRepo.findById(campId)
                .orElseThrow(()->new RuntimeException("DONATION CAMP NOT FOUND"));
        // approving the donation camp
        donationCamp.setApproved(true);
        donationCamp.setActive(true);
        //persisting the changes in the DB
       return donationCampRepo.save(donationCamp);
    }

    // getting list of donation camps that are approved by the admin
    @Override
    public List<DonationCamp> findByIsApprovedTrue() {

        return donationCampRepo.findByIsApprovedTrue();

    }

    // getting list of donation camps that are currently active (by the admin)
    @Override
    public List<DonationCamp> findByIsActiveTrue() {
        return donationCampRepo.findByIsActiveTrue();
    }

}
