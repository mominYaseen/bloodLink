package com.example.bloodLink.service.impl;

import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.repository.DonationCampRepo;
import com.example.bloodLink.service.SubAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubAdminServiceImpl implements SubAdminService {


    @Autowired
    private DonationCampRepo donationCampRepo;

    @Override
    public DonationCamp reqDonationCamp(DonationCamp camp) {

        return donationCampRepo.save(camp);


    }
}
