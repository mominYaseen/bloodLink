package com.example.bloodLink.repository;

import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.BloodInventoryLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BloodInventoryLogRepo extends JpaRepository<BloodInventoryLog , Long> {

    Optional<List<BloodInventoryLog>> findAllByBloodBankCenter(BloodBankCenter bloodBankCenter);

}
