package com.example.bloodLink.service.impl;

import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.repository.BloodBankCenterRepo;
import com.example.bloodLink.service.BloodBankCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodBankCenterServiceImpl implements BloodBankCenterService {


    @Autowired
    private BloodBankCenterRepo bloodBankCenterRepo;

    @Override
    public BloodBankCenter addBloodBankCenterToDb(BloodBankCenter center) {

        return bloodBankCenterRepo.save(center);
    }
}
