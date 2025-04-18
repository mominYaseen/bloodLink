package com.example.bloodLink.controller;


import com.example.bloodLink.dto.DonationCampResponseDTO;
import com.example.bloodLink.modals.SubAdmin;
import com.example.bloodLink.modals.DonationCamp;
import com.example.bloodLink.service.SubAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/admin")
public class SubAdminController {


    @Autowired
    private SubAdminService subAdminService;



    //    //open blood donation camp
    // get the user(admin) from the token and put admin.name to DonationCamp.setOrganizerName()
    @PostMapping("/req-donation-camp")
    public ResponseEntity<?> reqDonationCamp(@RequestBody DonationCamp camp) {


        // get the subAdmin from the security context
        // for now , I am getting it directly from the db using the subAdminService

        String email = "musa@hospital.com";// manually setting email till we get it from security context
        SubAdmin subAdmin = subAdminService.loadUserByUsername(email);


        // Edge Case 1: Null or incomplete request
        if (camp == null) {
            return ResponseEntity.badRequest().body("Request body cannot be null.");
        }

        if (camp.getCampName() == null || camp.getCampName().isEmpty()) {
            return ResponseEntity.badRequest().body("Camp name is required.");
        }

        if (camp.getCampDate() == null) {
            return ResponseEntity.badRequest().body("Camp date is required.");
        }

        if (camp.getStartTime() == null || camp.getEndTime() == null) {
            return ResponseEntity.badRequest().body("Start and End times are required.");
        }

        if (camp.getTotalSlots() <= 0) {
            return ResponseEntity.badRequest().body("Total slots must be greater than 0.");
        }

        if (camp.getLatitude() == 0.0 || camp.getLongitude() == 0.0) {
            return ResponseEntity.badRequest().body("Location coordinates are required.");
        }

        // Edge Case 2: Start time after end time
        if (camp.getStartTime().isAfter(camp.getEndTime())) {
            return ResponseEntity.badRequest().body("Start time cannot be after end time.");
        }

        // Edge Case 3: Camp date in the past
        if (camp.getCampDate().isBefore(LocalDate.now())) {
            return ResponseEntity.badRequest().body("Camp date must be in the future.");
        }

//         Edge Case 4: Organizer is not assigned (dummy fallback)
        if (subAdmin.getAssignedBloodBankCenter() == null || subAdmin.getAssignedBloodBankCenter().isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SubAdmin is not assigned to any hospital.");
        }



//         Set organizer name from admin
//        camp.setOrganizerName(subAdmin.getAssignedHospital());
        camp.setSubAdmin(subAdmin); // get this from the security context
        camp.setEmail(subAdmin.getEmail());
        try {
            DonationCamp savedCamp = subAdminService.reqDonationCamp(camp);
            return ResponseEntity.ok(new DonationCampResponseDTO(savedCamp));
        } catch (Exception e) {
            // Edge Case 5: Database or service failure
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to request donation camp. " + e.getMessage());
        }
    }

    // method for getting all donation camp requests

    @GetMapping("/get-requested-camps")
    public ResponseEntity<?> getAllRequestedCamps()
    {
        return null;
    }

}
