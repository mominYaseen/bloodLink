package com.example.bloodLink.controller;

import com.example.bloodLink.dto.*;
import com.example.bloodLink.modals.AuthUser;
import com.example.bloodLink.modals.UserEntity;
import com.example.bloodLink.service.CommonDataService;
import com.example.bloodLink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private CommonDataService commonDataService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/check-eligibility")
    public ResponseEntity<?> checkIfEligible(@RequestBody EligibilityFormDTO form){
        //get the email of user from security context
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userService.getUserByEmail(email);
        if (userService.checkIfEligible(form)){
            // get the email from jwt token and get curr user using the email and set
             user.setEligibleToDonate(true);
             user.setEligibilityCheckDone(true);
            userService.save(user);

            return ResponseEntity.ok(Map.of("isEligible", true)    );
        }else {
            user.setEligibleToDonate(false);
            user.setEligibilityCheckDone(true);
            userService.save(user);
             return ResponseEntity.ok(Map.of("isEligible", false)    );

        }

    }

//    @GetMapping("get-user")
//    public ResponseEntity<?> getUser(String ){
//
//    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto user) {
        try {
            // Check if user with this email already exists
            if (userService.getUserByEmail(user.getEmail()) != null) {
                return ResponseEntity.badRequest().body("Email already registered");
            }

            // Create and save AuthUser for authentication
            AuthUser authUser = new AuthUser();
            authUser.setEmail(user.getEmail());
            authUser.setPassword(passwordEncoder.encode(user.getPassword()));
            authUser.setRole("ROLE_USER");
            commonDataService.saveAuthUserToDb(authUser);

            // Save full user data
            return ResponseEntity.ok(userService.saveUserToDb(user));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Registration failed: " + e.getMessage());
        }
    }

    @GetMapping("/donation-history")
    public ResponseEntity<?> donationHistory(){
        // get from security context holder
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        try{
            List<DonationCampResponseToUser> donationList = userService.donationCampHistory(email)
                    .stream()
                    .map(DonationCampResponseToUser::new)
                    .toList();
            return  ResponseEntity.ok(donationList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
    @GetMapping("/get-low-blood")
    public ResponseEntity<?> getLowBloodInventory(){

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        String bloodGroup = userService.getUserByEmail(email).getBloodGroup();
        try{
            return ResponseEntity.ok(commonDataService.lowBloodInventoryByBloodGroup(bloodGroup)
                    .stream()
                    .map(BloodShortageResponse::new)
                    .toList()
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }

    }


    @GetMapping("/check-if-eligibility")
    public ResponseEntity<?> checkIfEligible() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        UserEntity user = userService.getUserByEmail(email);

        if (user.isEligibilityCheckDone()==true) {
            if (user.isEligibleToDonate()== true) {
//        System.out.println("EligibilityCheckResponse :"+user.isEligibleToDonate());
                return ResponseEntity.ok(new EligibilityCheckResponse( true,true)); //   checkDone  , eligibleToDonate
            } else {
                return ResponseEntity.ok(new EligibilityCheckResponse(true, false));
            }
        } else {
            return ResponseEntity.ok(new EligibilityCheckResponse(false, false));
        }
    }

    @GetMapping("/active-camps")
    public ResponseEntity<?> allActiveDonationCamps(){
        List<DonationCampResponseToUser> activeListOfDonationCamps = commonDataService.getAllActiveListOfDonationCamps()
                .stream()
                .map(DonationCampResponseToUser::new)
                .toList();

        // Edge Case 1: No donation camps found
        if (activeListOfDonationCamps.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO ACTIVE LIST OF DONATION CAMPS");
        }
        return ResponseEntity.ok(activeListOfDonationCamps);
    }

}




























