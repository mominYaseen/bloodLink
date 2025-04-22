package com.example.bloodLink.service.impl;

import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.BloodInventory;
import com.example.bloodLink.repository.BloodInventoryRepo;
import com.example.bloodLink.service.BloodInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodInventoryServiceImpl implements BloodInventoryService {

    @Autowired
    private BloodInventoryRepo bloodInventoryRepo;

    @Override
    public BloodInventory saveBloodInventory(BloodInventory bloodInventory) {
        return bloodInventoryRepo.save(bloodInventory);
    }

    @Override
    public BloodInventory findByBloodBankCenterAndBloodGroup(BloodBankCenter bloodBankCenter, String bloodGroup) {
        return bloodInventoryRepo.findByBloodBankCenterAndBloodGroup(bloodBankCenter,bloodGroup).
                orElseThrow(()->new RuntimeException("Inventory not found for group " + bloodGroup));
    }

//    @Override
//    public List<BloodInventory> findAllByBloodBankCenter(BloodBankCenter bloodBankCenter) {
//        return bloodInventoryRepo.findAllByBloodBankCenter(bloodBankCenter)
//                .orElseThrow(()->new RuntimeException("NO INVENTORY FOUND"));
//    }
}
