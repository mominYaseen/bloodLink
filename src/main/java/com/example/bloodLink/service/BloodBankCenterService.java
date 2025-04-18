package com.example.bloodLink.service;

import com.example.bloodLink.dto.BloodBankCenterRegistrationRequestDTO;
import com.example.bloodLink.modals.BloodBankCenter;

public interface BloodBankCenterService {
    BloodBankCenter addBloodBankCenterToDb(BloodBankCenterRegistrationRequestDTO center , String email);
}
