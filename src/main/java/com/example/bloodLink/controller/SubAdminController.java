package com.example.bloodLink.controller;


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
    private SubAdminService adminService;

    private static final SubAdmin DUMMY_SUB_ADMIN = new SubAdmin();

    static {
        DUMMY_SUB_ADMIN.setId(1L);
        DUMMY_SUB_ADMIN.setFirstName("Ayaan");
        DUMMY_SUB_ADMIN.setLastName("Qadri");
        DUMMY_SUB_ADMIN.setEmail("ayaan.qadri@hospital.com");
        DUMMY_SUB_ADMIN.setPassword("securePass123"); // Note: Passwords should be encrypted in real apps
        DUMMY_SUB_ADMIN.setPhoneNumber("+91-9123456780");
        DUMMY_SUB_ADMIN.setAssignedHospital("Kashmir Central Blood Bank");
    }

    //    //open blood donation camp
    // get the user(admin) from the token and put admin.name to DonationCamp.setOrganizerName()
    @PostMapping("/req-donation-camp")
    public ResponseEntity<?> reqDonationCamp(@RequestBody DonationCamp camp) {
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

        // Edge Case 4: Organizer is not assigned (dummy fallback)
        if (DUMMY_SUB_ADMIN.getAssignedHospital() == null || DUMMY_SUB_ADMIN.getAssignedHospital().isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SubAdmin is not assigned to any hospital.");
        }

        // Set organizer name from admin
//        camp.setOrganizerName(DUMMY_SUB_ADMIN.getAssignedHospital());

        try {
            DonationCamp savedCamp = adminService.reqDonationCamp(camp);
            return ResponseEntity.ok(savedCamp);
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
