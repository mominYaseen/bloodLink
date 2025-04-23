package com.example.bloodLink.repository;

import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.DonationCamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DonationCampRepo extends JpaRepository<DonationCamp,Long> {
    List<DonationCamp> findByIsApprovedFalse();
    List<DonationCamp> findByIsApprovedTrue();
    List<DonationCamp> findByIsActiveTrue();
    Optional<List<DonationCamp>> findByIsApprovedFalseAndBloodBankCenter(BloodBankCenter bloodBankCenter);
    Optional<List<DonationCamp>> findByIsActiveTrueAndBloodBankCenter(BloodBankCenter bloodBankCenter);

}
