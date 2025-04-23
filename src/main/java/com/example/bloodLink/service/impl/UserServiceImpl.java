package com.example.bloodLink.service.impl;

import com.example.bloodLink.dto.EligibilityFormDTO;
import com.example.bloodLink.modals.UserEntity;
import com.example.bloodLink.repository.UserRepo;
import com.example.bloodLink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserEntity getUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }



    @Override
    public boolean checkIfEligible( EligibilityFormDTO form) {


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

    @Override
    public UserEntity save(UserEntity user) {
        return userRepo.save(user);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepo.findAll();
    }


}
