package com.example.bloodLink.repository;

import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.BloodInventory;
import com.example.bloodLink.modals.BloodInventoryLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BloodInventoryRepo extends JpaRepository<BloodInventory , Long> {
    Optional<BloodInventory> findByBloodBankCenterAndBloodGroup(BloodBankCenter bloodBankCenter, String bloodGroup);
    List<BloodInventory> findAll();

}
