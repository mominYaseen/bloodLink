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

    // all blood center
    List<BloodBankCenter> getAllBloodBankCenters();









    // SUB-ADMIN RELATED SERVICES(FUNCTIONALITES)

    SubAdmin findSubAdminByEmail(String email);

    BloodBankCenter registerBloodCenterToDb(BloodBankCenterRegistrationRequestDTO bloodBankCenterResponseDTO, String email);
    BloodInventoryLog saveBloodLogOfBloodBankCenter(BloodInventoryLog bloodInventoryLog);

    List<DonationCamp> findByIsApprovedFalseAndBloodBankCenter(BloodBankCenter bloodBankCenter);

    List<DonationCamp> findByIsActiveTrueAndBloodBankCenter(BloodBankCenter bloodBankCenter);
    String registerDonorToDonationCamp(String donorEmail, Long campId);

    List<BloodInventory> lowBloodInventoryByBloodGroup(String bloodGroup);












    // COMMON SERVICES B/W SUPER-ADMIN AND SUB-ADMIN
    BloodBankCenter getCenter(Long id);

    // all log details according to bloodbank center
    List<BloodInventoryLog> findInventoryLogAllByBloodBankCenter(BloodBankCenter bloodBankCenter);


    // for saving user to authUser table
    AuthUser saveAuthUserToDb(AuthUser authUser);








}
