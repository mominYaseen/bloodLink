package com.example.bloodLink.repository;

import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.BloodInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BloodInventoryRepo extends JpaRepository<BloodInventory , Long> {
    Optional<BloodInventory> findByBloodBankCenterAndBloodGroup(BloodBankCenter bloodBankCenter, String bloodGroup);

    @Query("SELECT b FROM BloodInventory b WHERE b.bloodBankCenter = :bloodBankCenter AND b.availableUnits <= b.minimumUnits")
    Optional<List<BloodInventory>> findLowInventoryByBloodBankCenter(BloodBankCenter bloodBankCenter);

//    Optional<List<BloodInventory>> findAllByBloodBankCenter(BloodBankCenter bloodBankCenter);
}
