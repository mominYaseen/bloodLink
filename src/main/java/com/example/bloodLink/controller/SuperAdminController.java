package com.example.bloodLink.controller;

import com.example.bloodLink.dto.SubAdminDTO;
import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.modals.SubAdmin;
import com.example.bloodLink.modals.SuperAdmin;
import com.example.bloodLink.service.CommonDataService;
import com.example.bloodLink.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/super-admin")
public class SuperAdminController {


    @Autowired
    private SuperAdminService superAdminService;


    @Autowired
    private CommonDataService commonDataService;


    // function for creating subAdmin

    @PostMapping("/register-admin")
    public ResponseEntity<?> registerSubAdmin(@RequestBody SubAdmin admin){

        if (admin == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("INCORRECT DATA SEND");
        }else {
            admin.setCreatedAt(LocalDateTime.now());
            return ResponseEntity.ok(superAdminService.registerSubAdmin(admin));
        }


    }

    // getting all registeredSubAdmins
    @GetMapping("/get-registered-admins")
    public ResponseEntity<?> getAllRegisteredSubAdmin(){
        // get the email from security context and then call the superAdminService.findByEmail() to get the admin
        // and then fetch List<SubAdmin>

        //dummy email
        String email = "admin@email.com";
        SuperAdmin superAdmin = superAdminService.findByEmail(email);
        if (superAdmin == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SUPER_ADMIN NOT FOUND");

        }
        List<SubAdminDTO> subAdminDTOList = superAdmin.getListOfRegisteredAdmins()
                .stream()
                .map(SubAdminDTO::new)
                .toList();
        if (subAdminDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO REGISTERED SUB_ADMINS");
        }

        return ResponseEntity.ok(subAdminDTOList);

    }

    // function for seeing  blood donation camps that are not accepted yet
    @GetMapping("/get-requested-camps")
    public ResponseEntity<?> getAllRequestedCamps()
    {
        List<DonationCamp> allNonApprovedListOfDonationCamps = commonDataService.getAllNonApprovedListOfDonationCamps();
        // Edge Case 1: No donation camps found
        if (allNonApprovedListOfDonationCamps == null || allNonApprovedListOfDonationCamps.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No requested donation camps found.");
        }
        return ResponseEntity.ok(allNonApprovedListOfDonationCamps);
    }

    // function for approving the donation camp
    @PutMapping("/aprove-camp/{campId}")
    public ResponseEntity<?> approveDonationCamp(@PathVariable Long campId){

        if (campId == null ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PLEASE RECHECK campId");
        }
       return ResponseEntity.ok(commonDataService.approveDonationCamp(campId));

    }

    // function for seeing  blood donation camps that are not accepted yet
    @GetMapping("/approved-donation-camps")
    public ResponseEntity<?> allApprovedDonationCamps()
    {
        List<DonationCamp> approvedListOfDonationCamps = commonDataService.getAllApprovedListOfDonationCamps();
        // Edge Case 1: No donation camps found
        if (approvedListOfDonationCamps == null || approvedListOfDonationCamps.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO DONATION CAMP REQUEST ACCEPTED YET");
        }
        return ResponseEntity.ok(approvedListOfDonationCamps);
    }

    // get list of all active donation camps
    @GetMapping("/active-camps")
    public ResponseEntity<?> allActiveDonationCamps(){
        List<DonationCamp> activeListOfDonationCamps = commonDataService.getAllActiveListOfDonationCamps();
        // Edge Case 1: No donation camps found
        if (activeListOfDonationCamps == null || activeListOfDonationCamps.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO ACTIVE LIST OF DONATION CAMPS");
        }
        return ResponseEntity.ok(activeListOfDonationCamps);
    }

}
