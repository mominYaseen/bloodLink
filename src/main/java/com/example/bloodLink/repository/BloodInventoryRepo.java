package com.example.bloodLink.repository;

import com.example.bloodLink.modals.BloodInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodInventoryRepo extends JpaRepository<BloodInventory , Long> {
}
