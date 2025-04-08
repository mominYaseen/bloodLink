package com.example.bloodLink.controller;

import com.example.bloodLink.dto.EligibilityFormDTO;
import com.example.bloodLink.modals.UserEntity;
import com.example.bloodLink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/check-eligibility")
    public ResponseEntity<?> checkIfEligible(@RequestBody EligibilityFormDTO form){

        if (userService.checkIfEligible(form)){
            // get the email from jwt token and get curr user using the email and set
            // UserEntity.setEligibleToDonate()---> true or else false
            return ResponseEntity.ok("user eligible to donate");
        }else {
             return ResponseEntity.ok("user not-eligible to donate");

        }

    }

//    @GetMapping("get-user")
//    public ResponseEntity<?> getUser(String ){
//
//    }


}
