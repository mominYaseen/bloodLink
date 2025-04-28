package com.example.bloodLink.service;

import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.BloodInventoryLog;

import java.util.List;

public interface BloodInventoryLogService {
    BloodInventoryLog saveBloodLogOfBloodBankCenter(BloodInventoryLog bloodInventoryLog);
    List<BloodInventoryLog> findAllByBloodBankCenter(BloodBankCenter bloodBankCenter);
}
