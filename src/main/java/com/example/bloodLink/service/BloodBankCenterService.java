package com.example.bloodLink.service;

import com.example.bloodLink.dto.BloodBankCenterRegistrationRequestDTO;
import com.example.bloodLink.modals.BloodBankCenter;

import java.util.List;

public interface BloodBankCenterService {
    BloodBankCenter addBloodBankCenterToDb(BloodBankCenterRegistrationRequestDTO center , String email);
    List<BloodBankCenter> getAllBloodCenters();
    BloodBankCenter getCenter(Long id);
}
