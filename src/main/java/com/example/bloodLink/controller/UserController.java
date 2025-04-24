package com.example.bloodLink.controller;

import com.example.bloodLink.dto.DonationCampResponseToUser;
import com.example.bloodLink.dto.EligibilityFormDTO;
import com.example.bloodLink.modals.UserEntity;
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



    @PostMapping("/check-eligibility")
    public ResponseEntity<?> checkIfEligible(@RequestBody EligibilityFormDTO form){

        if (userService.checkIfEligible(form)){
            // get the email from jwt token and get curr user using the email and set
            // UserEntity.setEligibleToDonate()---> true
            // UserEntity.setEligibilityCheckDone()---> true

            return ResponseEntity.ok("user eligible to donate");
        }else {
             return ResponseEntity.ok("user not-eligible to donate");

        }

    }

//    @GetMapping("get-user")
//    public ResponseEntity<?> getUser(String ){
//
//    }

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user){
        return userService.save(user);
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


}




























