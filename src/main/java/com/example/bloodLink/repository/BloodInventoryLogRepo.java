package com.example.bloodLink.repository;

import com.example.bloodLink.modals.BloodInventoryLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodInventoryLogRepo extends JpaRepository<BloodInventoryLog , Long> {
}
