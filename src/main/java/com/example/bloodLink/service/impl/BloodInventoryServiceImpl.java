package com.example.bloodLink.service.impl;

import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.BloodInventory;
import com.example.bloodLink.modals.SubAdmin;
import com.example.bloodLink.repository.BloodInventoryRepo;
import com.example.bloodLink.service.BloodInventoryService;
import com.example.bloodLink.service.SubAdminService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodInventoryServiceImpl implements BloodInventoryService {

    @Autowired
    private BloodInventoryRepo bloodInventoryRepo;

    @Autowired
    private SubAdminService subAdminService;

    @Override
    public BloodInventory saveBloodInventory(BloodInventory bloodInventory) {
        return bloodInventoryRepo.save(bloodInventory);
    }

    @Override
    public BloodInventory findByBloodBankCenterAndBloodGroup(BloodBankCenter bloodBankCenter, String bloodGroup) {
        return bloodInventoryRepo.findByBloodBankCenterAndBloodGroup(bloodBankCenter,bloodGroup).
                orElseThrow(()->new RuntimeException("Inventory not found for group " + bloodGroup));
    }

    @Override
    public List<BloodInventory> findLowInventoryByBloodBankCenter() {

        // get the subAdmin-Email from  security context holder and then get the blood bank center and send it in the repo's method
        //currently using custom email

        String email  = "musa@hospital.com";
        SubAdmin admin = subAdminService.findByEmail(email);
        if (admin == null){
            throw new EntityNotFoundException("ADMIN DOES NOT EXIST");
        }
        BloodBankCenter bloodBankCenter = admin.getBloodBankCenter();
        if (bloodBankCenter == null){
            throw new EntityNotFoundException("PLEASE REGISTER BLOOD BANK CENTER ");
        }

        List<BloodInventory> lowInventoryByBloodBankCenter = bloodInventoryRepo.
                findLowInventoryByBloodBankCenter(bloodBankCenter)
                .orElseThrow(()->new RuntimeException("NO MINIMUM BLOOD QUANTIY"));


        return lowInventoryByBloodBankCenter;
    }

//    @Override
//    public List<BloodInventory> findAllByBloodBankCenter(BloodBankCenter bloodBankCenter) {
//        return bloodInventoryRepo.findAllByBloodBankCenter(bloodBankCenter)
//                .orElseThrow(()->new RuntimeException("NO INVENTORY FOUND"));
//    }
}



















