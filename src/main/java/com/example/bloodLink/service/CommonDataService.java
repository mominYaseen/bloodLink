package com.example.bloodLink.service;

import com.example.bloodLink.dto.BloodBankCenterRegistrationRequestDTO;
import com.example.bloodLink.dto.BloodBankCenterResponseDTO;
import com.example.bloodLink.modals.*;

import java.util.List;

public interface CommonDataService {

    // SUPER-ADMIN RELATED SERVICES(FUNCTIONALITIES)

    //contains Donation camp data that is not approved by the admin (for super admin)
    List<DonationCamp> getAllNonApprovedListOfDonationCamps();

    // approve/activate donationCamp (for super admin)
    DonationCamp approveDonationCamp(Long campId);

    //contains Donation camp data that is  approved by the admin (for super admin)
    List<DonationCamp> getAllApprovedListOfDonationCamps();

    //contains Donation camp data that is  currently active (for super admin)
    List<DonationCamp> getAllActiveListOfDonationCamps();





    // SUB-ADMIN RELATED SERVICES(FUNCTIONALITES)

    SubAdmin findSubAdminByEmail(String email);

    BloodBankCenter registerBloodCenterToDb(BloodBankCenterRegistrationRequestDTO bloodBankCenterResponseDTO, String email);
    BloodInventoryLog saveBloodLogOfBloodBankCenter(BloodInventoryLog bloodInventoryLog);

    List<DonationCamp> findByIsApprovedFalseAndBloodBankCenter(BloodBankCenter bloodBankCenter);

    List<DonationCamp> findByIsActiveTrueAndBloodBankCenter(BloodBankCenter bloodBankCenter);
    String registerDonorToDonationCamp(String donorEmail, Long campId);
    List<BloodInventory> findLowInventoryByBloodBankCenter();



    //    List<BloodInventory> getBloodInventory(BloodBankCenter bloodBankCenter);
}
