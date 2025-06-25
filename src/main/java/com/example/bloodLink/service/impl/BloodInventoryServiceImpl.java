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

import java.util.Collections;
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
    return bloodInventoryRepo.findByBloodBankCenterAndBloodGroup(bloodBankCenter, bloodGroup)
        .orElseThrow(() -> new RuntimeException("Inventory not found for group " + bloodGroup));
  }

  public List<BloodInventory> getLowBloodInventory() {

    System.out.println("In BloodInventoryServiceImpl.getLowBloodInventory()");
    List<BloodInventory> result = bloodInventoryRepo.findAll().stream()
        .filter(inventory -> inventory.getAvailableUnits() <= inventory.getMinimumUnits())
        .toList();

    System.out.println("IN BLOOD Inventory Service ");
    for (BloodInventory bloodInventory : result) {

        System.out.println(bloodInventory.toString());
    }

    return result;

  }

  @Override
  public List<BloodInventory> lowBloodInventoryByBloodGroup(String bloodGroup) {

 //   System.out.println("In BloodInventoryServiceImpl.lowBloodInventoryByBloodGroup()");
    List<BloodInventory> result = getLowBloodInventory().stream()
    .filter(inventory -> inventory.getBloodGroup().equalsIgnoreCase(bloodGroup)).toList();
//    System.out.println("--------------------------------------------------");
//    for (BloodInventory bloodInventory : result) {
//      System.out.println(bloodInventory.getBloodGroup().toString());
//    }


    return result;
    // getLowBloodInventory()
    // .stream()
    // .filter(inventory -> inventory.getBloodGroup().equalsIgnoreCase(bloodGroup))
    // .toList();
  }

}
