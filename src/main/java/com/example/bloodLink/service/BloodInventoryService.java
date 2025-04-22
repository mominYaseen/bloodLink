package com.example.bloodLink.service;

import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.BloodInventory;

public interface BloodInventoryService {
    BloodInventory saveBloodInventory(BloodInventory bloodInventory);
    BloodInventory findByBloodBankCenterAndBloodGroup(BloodBankCenter bloodBankCenter, String bloodGroup);
}
