package com.example.bloodLink.service;

import com.example.bloodLink.dto.BloodBankCenterRegistrationRequestDTO;
import com.example.bloodLink.dto.BloodBankCenterResponseDTO;
import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.modals.SubAdmin;

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
}
