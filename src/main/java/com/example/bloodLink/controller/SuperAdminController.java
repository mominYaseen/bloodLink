package com.example.bloodLink.controller;

import com.example.bloodLink.dto.BloodBankCenterResponseDTO;
import com.example.bloodLink.dto.DonationCampResponseToSuperAdmin;
import com.example.bloodLink.dto.SubAdminCreateDTO;
import com.example.bloodLink.dto.SubAdminResponseDTO;
import com.example.bloodLink.modals.*;
import com.example.bloodLink.service.CommonDataService;
import com.example.bloodLink.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/super-admin")
public class SuperAdminController {


    @Autowired
    private SuperAdminService superAdminService;


    @Autowired
    private CommonDataService commonDataService;

    @Autowired
    private PasswordEncoder passwordEncoder;



//    @PostMapping("")


    // function for creating subAdmin

    @PostMapping("/register-admin")
    public ResponseEntity<?> registerSubAdmin(@RequestBody SubAdminCreateDTO subAdminCreateDTO){


        if (subAdminCreateDTO == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("INCORRECT DATA SEND");
        }else {
            SubAdmin subAdmin = new SubAdmin();
            subAdmin.setFirstName(subAdminCreateDTO.getFirstName());
            subAdmin.setLastName(subAdminCreateDTO.getLastName());
            subAdmin.setEmail(subAdminCreateDTO.getEmail());
            subAdmin.setPhoneNumber(subAdminCreateDTO.getPhoneNumber());
            subAdmin.setAssignedBloodBankCenter(subAdminCreateDTO.getAssignedBloodBankCenterName());
            subAdmin.setRole("ROLE_SUB_ADMIN");

            subAdmin.setCreatedAt(LocalDateTime.now());
            subAdmin.setBloodBankCenter(null);
            try{
                AuthUser authUser = new AuthUser();
                authUser.setEmail(subAdmin.getEmail());
                authUser.setPassword(passwordEncoder.encode(subAdminCreateDTO.getPassword()));
                authUser.setRole(subAdmin.getRole());


                commonDataService.saveAuthUserToDb(authUser);
                return ResponseEntity.ok(new SubAdminResponseDTO(superAdminService.registerSubAdmin(subAdmin)));

            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
        }


    }

    // getting all registeredSubAdmins
    @GetMapping("/get-registered-admins")
    public ResponseEntity<?> getAllRegisteredSubAdmin(){
        // get the email from security context and then call the superAdminService.findByEmail() to get the admin
        // and then fetch List<SubAdmin>

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        SuperAdmin superAdmin = superAdminService.findByEmail(email);
        if (superAdmin == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SUPER_ADMIN NOT FOUND");

        }
        List<SubAdminResponseDTO> subAdminResponseDto = superAdmin.getListOfRegisteredAdmins()
                .stream()
                .map(SubAdminResponseDTO::new)
                .toList();
        if (subAdminResponseDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO REGISTERED SUB_ADMINS");
        }

        return ResponseEntity.ok(subAdminResponseDto);

    }

    // function for seeing  blood donation camps that are not accepted yet
    @GetMapping("/get-requested-camps")
    public ResponseEntity<?> getAllRequestedCamps()
    {
        List<DonationCampResponseToSuperAdmin> allNonApprovedListOfDonationCamps = commonDataService.getAllNonApprovedListOfDonationCamps()
                .stream()
                .map(DonationCampResponseToSuperAdmin::new)
                .toList();
        // Edge Case 1: No donation camps found
        if (allNonApprovedListOfDonationCamps == null || allNonApprovedListOfDonationCamps.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No requested donation camps found.");
        }

        return ResponseEntity.ok(allNonApprovedListOfDonationCamps);
    }

    // function for approving the donation camp
    @PutMapping("/approve-camp/{campId}")
    public ResponseEntity<?> approveDonationCamp(@PathVariable Long campId){

        if (campId == null ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PLEASE RECHECK campId");
        }
        try {
            return ResponseEntity.ok(new DonationCampResponseToSuperAdmin(commonDataService.approveDonationCamp(campId)));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }

    }

    // function for seeing  blood donation camps that are approved by the super admin
    @GetMapping("/approved-donation-camps")
    public ResponseEntity<?> allApprovedDonationCamps()
    {
//        List<DonationCamp> approvedListOfDonationCamps = commonDataService.getAllApprovedListOfDonationCamps();

       List<DonationCampResponseToSuperAdmin> approvedListOfDonationCamps =  commonDataService.getAllApprovedListOfDonationCamps()
                .stream()
                .map(DonationCampResponseToSuperAdmin::new)
                .toList();
        // Edge Case 1: No donation camps found
        if (approvedListOfDonationCamps == null || approvedListOfDonationCamps.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO DONATION CAMP REQUEST ACCEPTED YET");
        }
        return ResponseEntity.ok(approvedListOfDonationCamps);
    }

    // get list of all active donation camps
    @GetMapping("/active-camps")
    public ResponseEntity<?> allActiveDonationCamps(){
        List<DonationCampResponseToSuperAdmin> activeListOfDonationCamps = commonDataService.getAllActiveListOfDonationCamps()
                .stream()
                .map(DonationCampResponseToSuperAdmin::new)
                .toList();

        // Edge Case 1: No donation camps found
        if (activeListOfDonationCamps.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO ACTIVE LIST OF DONATION CAMPS");
        }
        return ResponseEntity.ok(activeListOfDonationCamps);
    }



    // getting all registered blood bank centers
    @GetMapping("/get-centers")
    public  ResponseEntity<?> getAllBloodBankCenters()
    {
        List<BloodBankCenterResponseDTO> listOfBloodCenters = commonDataService.getAllBloodBankCenters()
                .stream()
                .map(BloodBankCenterResponseDTO::new)
                .toList();

        return ResponseEntity.ok(listOfBloodCenters);

    }

    @GetMapping("/get-logs/{centerId}")
    public ResponseEntity<?> getAllLogs(@PathVariable Long centerId){
        BloodBankCenter bloodBankCenter = commonDataService.getCenter(centerId);

        return ResponseEntity.ok(  commonDataService.findInventoryLogAllByBloodBankCenter(bloodBankCenter));
    }


}
