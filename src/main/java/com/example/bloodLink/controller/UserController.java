package com.example.bloodLink.controller;

import com.example.bloodLink.dto.BloodShortageResponse;
import com.example.bloodLink.dto.DonationCampResponseToSuperAdmin;
import com.example.bloodLink.dto.DonationCampResponseToUser;
import com.example.bloodLink.dto.EligibilityFormDTO;
import com.example.bloodLink.modals.AuthUser;
import com.example.bloodLink.modals.UserEntity;
import com.example.bloodLink.service.CommonDataService;
import com.example.bloodLink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private CommonDataService commonDataService;


    @PostMapping("/check-eligibility")
    public ResponseEntity<?> checkIfEligible(@RequestBody EligibilityFormDTO form){
        //get the email of user from security context
        String email = "momin@email.com";
        UserEntity user = userService.getUserByEmail(email);
        if (userService.checkIfEligible(form)){
            // get the email from jwt token and get curr user using the email and set
             user.setEligibleToDonate(true);
             user.setEligibilityCheckDone(true);

            return ResponseEntity.ok(" eligible to donate");
        }else {
            user.setEligibleToDonate(false);
            user.setEligibilityCheckDone(true);
             return ResponseEntity.ok(" not-eligible to donate");

        }

    }

//    @GetMapping("get-user")
//    public ResponseEntity<?> getUser(String ){
//
//    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserEntity user){



        try{
            AuthUser authUser = new AuthUser();
            authUser.setEmail(user.getEmail());
            authUser.setPassword(user.getPassword());
            authUser.setRole("ROLE_USER");

            commonDataService.saveAuthUserToDb(authUser);


            return ResponseEntity.ok(userService.save(user));
        } catch (Exception e) {
            return ResponseEntity.ok(new RuntimeException(e));
        }

    }

    @GetMapping("/donation-history")
    public ResponseEntity<?> donationHistory(){
        // get from security context holder
        String email = "momin@email.com";
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
        String email = "momin@email.com";
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

        // Replace this with SecurityContextHolder logic in production
        String email = "shelly80@yahoo.com";

        UserEntity user = userService.getUserByEmail(email);

        if (user.isEligibilityCheckDone()) {
            if (user.isEligibleToDonate()) {
                return ResponseEntity.ok("eligible");
            } else {
                return ResponseEntity.ok("not eligible");
            }
        } else {
            return ResponseEntity.ok("eligibility check not done");
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




























