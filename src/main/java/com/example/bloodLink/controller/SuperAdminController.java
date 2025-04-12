package com.example.bloodLink.controller;

import com.example.bloodLink.modals.SubAdmin;
import com.example.bloodLink.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/super-admin")
public class SuperAdminController {


    @Autowired
    private SuperAdminService superAdminService;




    // function for creating subAdmin

    @PostMapping("/register-admin")
    public ResponseEntity<?> registerSubAdmin(@RequestBody SubAdmin admin){

        if (admin == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("INCORRECT DATA SEND");
        }else {
            return ResponseEntity.ok(superAdminService.registerSubAdmin(admin));
        }


    }

    // function for uploading blood donation camps


}
