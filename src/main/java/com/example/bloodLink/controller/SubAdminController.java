package com.example.bloodLink.controller;


import com.example.bloodLink.dto.*;
import com.example.bloodLink.modals.*;
import com.example.bloodLink.service.BloodInventoryLogService;
import com.example.bloodLink.service.CommonDataService;
import com.example.bloodLink.service.SubAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class SubAdminController {


    @Autowired
    private SubAdminService subAdminService;

    @Autowired
    private CommonDataService commonDataService;

    @Autowired
    private BloodInventoryLogService bloodInventoryLogService;

    //    //open blood donation camp
    // get the user(admin) from the token and put admin.name to DonationCamp.setOrganizerName()
    @PostMapping("/req-donation-camp")
    public ResponseEntity<?> reqDonationCamp(@RequestBody DonationCamp camp) {


        // get the subAdmin from the security context
        // for now , I am getting it directly from the db using the subAdminService

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        SubAdmin subAdmin = subAdminService.findByEmail(email);
        BloodBankCenter bloodBankCenter = subAdmin.getBloodBankCenter();

        // Edge Case 1: Null or incomplete request
        if (camp == null) {
            return ResponseEntity.badRequest().body("Request body cannot be null.");
        }
        if (bloodBankCenter==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PLEASE ASSIGN BLOOD BANK FIRST");

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
//        camp.setSubAdmin(subAdmin); // get this from the security context
        camp.setEmail(subAdmin.getEmail());
        camp.setOrganizerName(subAdmin.getBloodBankCenter().getName());

        // setting the blood bank center
        camp.setBloodBankCenter(bloodBankCenter);
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
    public ResponseEntity<?> getAllRequestedCamps() {


        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        SubAdmin subAdmin = subAdminService.findByEmail(email);
        BloodBankCenter center = subAdmin.getBloodBankCenter();

        if (center == null) {
                return ResponseEntity.badRequest().body("No blood bank center linked to this SubAdmin.");
        }
        try{
            List<DonationCampResponseDTO> requestedDonationList = commonDataService.findByIsApprovedFalseAndBloodBankCenter(center)
                    .stream()
                    .map(DonationCampResponseDTO::new)
                    .toList();

            return ResponseEntity.ok(requestedDonationList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to fetch requested camps: " + e.getMessage());
        }
    }


    // method for getting all donation camp requests

    @GetMapping("/get-active-camps")
    public ResponseEntity<?> getAllActiveCamps() {


        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        SubAdmin subAdmin = subAdminService.findByEmail(email);
        BloodBankCenter center = subAdmin.getBloodBankCenter();

        if (center == null) {
            return ResponseEntity.badRequest().body("No blood bank center linked to this SubAdmin.");
        }
        try{
            List<DonationCampResponseDTO> requestedDonationList = commonDataService.findByIsActiveTrueAndBloodBankCenter(center)
                    .stream()
                    .map(DonationCampResponseDTO::new)
                    .toList();

            return ResponseEntity.ok(requestedDonationList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to fetch requested camps: " + e.getMessage());
        }
    }


    // METHOD FOR ADDING A BLOOD-BANK CENTER
    @PostMapping("/add-blood-Bank")
    public ResponseEntity<?> addBloodCenterToDb(@RequestBody BloodBankCenterRegistrationRequestDTO dto ){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        try{
            return ResponseEntity.ok(new BloodBankCenterResponseDTO(commonDataService.registerBloodCenterToDb(dto,email)));
        }catch (IllegalStateException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }


    }


    //method for bloodInventoryLog

    @PostMapping("/add-log")
    public ResponseEntity<?> bloodInventoryLog(@RequestBody BloodInventoryLogDTO dto) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        //  Edge Case 1: SubAdmin not found
        SubAdmin subAdmin = subAdminService.findByEmail(email);
        if (subAdmin == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("SubAdmin not found.");
        }

        //  Edge Case 2: SubAdmin has no BloodBankCenter assigned
        BloodBankCenter bloodBankCenter = subAdmin.getBloodBankCenter();
        if (bloodBankCenter == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PLEASE ASSIGN BLOOD BANK FIRST.");
        }

        //  Edge Case 3: Missing or invalid blood group
        if (dto.getBloodGroup() == null || dto.getBloodGroup().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Blood group is required.");
        }

        //  Edge Case 4: Quantity is 0
        if (dto.getQuantityChanged() == 0) {
            return ResponseEntity.badRequest().body("Quantity changed must be non-zero.");
        }

        //  Edge Case 5: Invalid action type
        List<String> validActions = List.of("DONATION", "REQUEST", "MANUAL_ADJUSTMENT");
        if (dto.getActionType() == null || !validActions.contains(dto.getActionType().toUpperCase())) {
            return ResponseEntity.badRequest().body("Invalid action type. Must be one of: " + validActions);
        }

        //  Proceed to create the log
        BloodInventoryLog log = new BloodInventoryLog();
        log.setBloodGroup(dto.getBloodGroup());
        log.setQuantityChanged(dto.getQuantityChanged());
        log.setActionType(dto.getActionType());
        log.setPerformedBy(email);
        log.setRemarks(dto.getRemarks()); // or generate dynamically
        log.setBloodBankCenter(bloodBankCenter);

//        BloodInventoryLog savedLog = bloodInventoryLogService.saveBloodLogOfBloodBankCenter(log);
//        return ResponseEntity.ok(savedLog);

        try {
            BloodInventoryLog savedLog = commonDataService.saveBloodLogOfBloodBankCenter(log);
            return ResponseEntity.ok(savedLog);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    // check blood inventory of bloodBankCenter
    @GetMapping("/get-blood-inventory")
    public ResponseEntity<?> getBloodInventory() {
        // get from the security context
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        SubAdmin subAdmin = subAdminService.findByEmail(email);
        if (subAdmin == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource Not Found");
        }

        BloodBankCenter bloodBankCenter = subAdmin.getBloodBankCenter();
        if (bloodBankCenter == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PLEASE ASSIGN BLOOD BANK FIRST.");
        }

        if (bloodBankCenter.getBloodInventories() == null || bloodBankCenter.getBloodInventories().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No blood inventory records found.");
        }

        List<BloodInventoryResponseDto> bloodInventoryResponseDtoList = bloodBankCenter.getBloodInventories()
                .stream()
                .map(BloodInventoryResponseDto::new)
                .toList();

        return ResponseEntity.ok(bloodInventoryResponseDtoList);
    }

    @PostMapping("/register-donor-to-camp/{campId}/{donorEmail}")
    public ResponseEntity<?> registerDonorToCamp(@PathVariable Long campId , @PathVariable String donorEmail){

        try{
            return ResponseEntity.ok(commonDataService.registerDonorToDonationCamp(donorEmail,campId));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }


    @GetMapping("/get-logs")
    public ResponseEntity<?> getAllLogs(){

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        SubAdmin subAdmin = subAdminService.findByEmail(email);
        if (subAdmin == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource Not Found");
        }

        BloodBankCenter bloodBankCenter = subAdmin.getBloodBankCenter();
        if (bloodBankCenter == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PLEASE ASSIGN BLOOD BANK FIRST.");
        }

        return ResponseEntity.ok(  commonDataService.findInventoryLogAllByBloodBankCenter(bloodBankCenter));
    }


}















