package com.example.bloodLink.service.impl;

import com.example.bloodLink.modals.BloodInventory;
import com.example.bloodLink.modals.BloodInventoryLog;
import com.example.bloodLink.repository.BloodInventoryLogRepo;
import com.example.bloodLink.service.BloodInventoryLogService;
import com.example.bloodLink.service.BloodInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BLoodInventoryLogServiceImpl implements BloodInventoryLogService {


    @Autowired
    private BloodInventoryLogRepo bloodInventoryLogRepo;

    @Autowired
    private BloodInventoryService bloodInventoryService;


    @Override
    public BloodInventoryLog saveBloodLogOfBloodBankCenter(BloodInventoryLog bloodInventoryLog) {
        BloodInventory bloodInventoryRow = bloodInventoryService.findByBloodBankCenterAndBloodGroup(
                bloodInventoryLog.getBloodBankCenter(),
                bloodInventoryLog.getBloodGroup()
        );

        int availableUnits = bloodInventoryRow.getAvailableUnits();      // existing units
        int quantityChange = bloodInventoryLog.getQuantityChanged();     // could be + or -
        String actionType = bloodInventoryLog.getActionType().toUpperCase();
        //  Reject if trying to deduct more units than available
        if (actionType.equals("REQUEST") &&
            quantityChange < 0 && availableUnits < Math.abs(quantityChange)
        ){
            throw new IllegalStateException("Not enough units available for this request. Available: "
                    + availableUnits + ", Requested: " + Math.abs(quantityChange));
        }

        //  Update the available units in inventory
        bloodInventoryRow.setAvailableUnits(availableUnits + quantityChange);
        bloodInventoryRow.setLastUpdated(LocalDateTime.now()); // updating the last updated time of bloodInventory row
        bloodInventoryService.saveBloodInventory(bloodInventoryRow); // Save the updated inventory

        return bloodInventoryLogRepo.save(bloodInventoryLog);
    }

}
