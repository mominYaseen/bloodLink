package com.example.bloodLink.controller;

import com.example.bloodLink.modals.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
public class UserController {





    @PostMapping("/register")
    public ResponseEntity<?> registerAccount(UserEntity user){
        // register user account

        // call userService._____() method
        return ResponseEntity.ok("account registered");
    }



}
