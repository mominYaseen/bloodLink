package com.example.bloodLink.service.impl;

import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.modals.SubAdmin;
import com.example.bloodLink.repository.DonationCampRepo;
import com.example.bloodLink.repository.SubAdminRepo;
import com.example.bloodLink.service.DonationCampService;
import com.example.bloodLink.service.SubAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubAdminServiceImpl implements SubAdminService  {


    @Autowired
    private DonationCampService donationCampService;

    @Autowired
    private SubAdminRepo subAdminRepo;

    @Override
    public DonationCamp reqDonationCamp(DonationCamp camp) {

        return donationCampService.reqDonationCamp(camp);
    }

    @Override
    public SubAdmin findByEmail(String email) {
      return   subAdminRepo.findByEmail(email);
    }

//    @Override
//    public List<?> registerForDonationCamp(String email,DonationCamp donationCamp) {
//
//        return null;
//    }

}
