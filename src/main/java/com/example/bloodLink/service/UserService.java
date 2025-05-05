package com.example.bloodLink.service;

import com.example.bloodLink.dto.EligibilityFormDTO;
import com.example.bloodLink.dto.UserDto;
import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.modals.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity getUserByEmail(String email);
    boolean checkIfEligible(EligibilityFormDTO form);
    UserEntity saveUserToDb(UserDto user);
    UserEntity save(UserEntity user);
    List<UserEntity> getAllUser();
    List<DonationCamp> donationCampHistory(String email);
    List<UserEntity> findByBloodGroupAndEligibleToDonateTrue(String bloodGroup);


}
