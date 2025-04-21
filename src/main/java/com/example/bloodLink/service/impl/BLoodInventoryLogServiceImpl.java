package com.example.bloodLink.service.impl;

import com.example.bloodLink.modals.BloodInventoryLog;
import com.example.bloodLink.repository.BloodInventoryLogRepo;
import com.example.bloodLink.service.BloodInventoryLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BLoodInventoryLogServiceImpl implements BloodInventoryLogService {


    @Autowired
    private BloodInventoryLogRepo bloodInventoryLogRepo;


    @Override
    public BloodInventoryLog saveBloodLogOfBloodBankCenter(BloodInventoryLog bloodInventoryLog) {

        return bloodInventoryLogRepo.save(bloodInventoryLog);
    }
}
