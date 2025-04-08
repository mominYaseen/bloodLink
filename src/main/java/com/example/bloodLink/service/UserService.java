package com.example.bloodLink.service;

import com.example.bloodLink.dto.EligibilityFormDTO;
import com.example.bloodLink.modals.UserEntity;

public interface UserService {

    UserEntity getUserByEmail(String email);
    boolean checkIfEligible(EligibilityFormDTO form);

}
