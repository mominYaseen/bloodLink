package com.example.bloodLink.service.impl;

import com.example.bloodLink.dto.BloodBankCenterRegistrationRequestDTO;
import com.example.bloodLink.dto.BloodBankCenterResponseDTO;
import com.example.bloodLink.modals.*;
import com.example.bloodLink.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommonDataServiceImpl implements CommonDataService {



    @Autowired  // DONATION CAMP SERVICE
    private DonationCampService donationCampService;

    @Autowired  // BLOOD BANK SERVICE
    private BloodBankCenterService bloodBankCenterService;


    @Autowired
    private SubAdminService subAdminService;


    @Autowired
    private BloodInventoryService bloodInventoryService;

    @Autowired
    private BloodInventoryLogService bloodInventoryLogService;


    // SUPER-ADMIN RELATED SERVICES(FUNCTIONALITIES)

    @Override
    public List<DonationCamp> getAllNonApprovedListOfDonationCamps() {
        List<DonationCamp> pendingDonationCampReqList = donationCampService.findByIsApprovedFalse();
        // Edge Case 1: Null safety (just in case the repository returns null, though it should ideally return empty list)
        if (pendingDonationCampReqList == null) {
            return new ArrayList<>();
        }
        return pendingDonationCampReqList;
    }

    // approving donation camp
    @Override
    public DonationCamp approveDonationCamp(Long campId) {
        return donationCampService.approveDonationCamp(campId);
    }

    @Override
    public List<DonationCamp> getAllApprovedListOfDonationCamps() {
       return donationCampService.findByIsApprovedTrue();
    }

    @Override
    public List<DonationCamp> getAllActiveListOfDonationCamps() {
        return donationCampService.findByIsActiveTrue();
    }


    // SUB-ADMIN RELATED SERVICES(FUNCTIONALITES)





    @Override
    public SubAdmin findSubAdminByEmail(String email) {
        return subAdminService.findByEmail(email);
    }

    @Override
    public BloodBankCenter registerBloodCenterToDb(BloodBankCenterRegistrationRequestDTO bloodBankCenterResponseDTO, String email) {
        return bloodBankCenterService.addBloodBankCenterToDb(bloodBankCenterResponseDTO , email);
    }

    @Override
    public BloodInventoryLog saveBloodLogOfBloodBankCenter(BloodInventoryLog bloodInventoryLog) {
        return bloodInventoryLogService.saveBloodLogOfBloodBankCenter(bloodInventoryLog);
    }

    @Override
    public List<DonationCamp> findByIsApprovedFalseAndBloodBankCenter(BloodBankCenter bloodBankCenter) {
        return  donationCampService.findByIsApprovedFalseAndBloodBankCenter(bloodBankCenter);
    }

    @Override
    public List<DonationCamp> findByIsActiveTrueAndBloodBankCenter(BloodBankCenter bloodBankCenter) {
        return donationCampService.findByIsActiveTrueAndBloodBankCenter(bloodBankCenter);
    }

    @Override
    public String registerDonorToDonationCamp(String donorEmail, Long campId) {
        return donationCampService.registerForDonationCamp(donorEmail,campId);
    }

    @Override
    public List<BloodInventory> lowBloodInventoryByBloodGroup(String bloodGroup) {
        return bloodInventoryService.lowBloodInventoryByBloodGroup(bloodGroup);
    }




}
