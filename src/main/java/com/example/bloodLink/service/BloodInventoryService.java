package com.example.bloodLink.service;

import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.BloodInventory;

import java.util.List;

public interface BloodInventoryService {
    BloodInventory saveBloodInventory(BloodInventory bloodInventory);
    BloodInventory findByBloodBankCenterAndBloodGroup(BloodBankCenter bloodBankCenter, String bloodGroup);
    List<BloodInventory> findLowInventoryByBloodBankCenter();
//    List<BloodInventory> findAllByBloodBankCenter(BloodBankCenter bloodBankCenter);
}
