package com.example.bloodLink.service.impl;

import com.example.bloodLink.dto.BloodBankCenterRegistrationRequestDTO;
import com.example.bloodLink.dto.BloodBankCenterResponseDTO;
import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.modals.SubAdmin;
import com.example.bloodLink.service.BloodBankCenterService;
import com.example.bloodLink.service.CommonDataService;
import com.example.bloodLink.service.DonationCampService;
import com.example.bloodLink.service.SubAdminService;
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


}
