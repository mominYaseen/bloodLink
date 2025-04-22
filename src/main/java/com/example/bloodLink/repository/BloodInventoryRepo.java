package com.example.bloodLink.repository;

import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.BloodInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BloodInventoryRepo extends JpaRepository<BloodInventory , Long> {
    Optional<BloodInventory> findByBloodBankCenterAndBloodGroup(BloodBankCenter bloodBankCenter, String bloodGroup);
//    Optional<List<BloodInventory>> findAllByBloodBankCenter(BloodBankCenter bloodBankCenter);
}
