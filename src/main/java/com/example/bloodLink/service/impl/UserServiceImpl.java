package com.example.bloodLink.service.impl;

import com.example.bloodLink.dto.EligibilityFormDTO;
import com.example.bloodLink.modals.UserEntity;
import com.example.bloodLink.repository.UserRepo;
import com.example.bloodLink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserEntity getUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }

    @Override
    public boolean checkEligibility( EligibilityFormDTO form) {


        if (!form.isFeelingWell() || form.isRecentDonation() ||
            form.isTakingMedication() || form.isHasChronicIllness() ||
            form.isHasInfection() || form.isCovidRecently() || form.isMalariaTravel() ||
            form.isHasTattoo() || form.isTestedPositiveHIV() || form.isPregnant() ||
            form.getWeight()<=40
        ){
            return false;
        }else {
            return true;
        }


    }


}
