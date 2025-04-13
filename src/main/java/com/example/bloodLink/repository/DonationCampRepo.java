package com.example.bloodLink.repository;

import com.example.bloodLink.modals.DonationCamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationCampRepo extends JpaRepository<DonationCamp,Long> {
    List<DonationCamp> findByIsApprovedFalse();
    List<DonationCamp> findByIsApprovedTrue();
    List<DonationCamp> findByIsActiveTrue();
}
