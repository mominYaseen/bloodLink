package com.example.bloodLink.controller;

import com.example.bloodLink.dto.SubAdminDTO;
import com.example.bloodLink.modals.SubAdmin;
import com.example.bloodLink.modals.SuperAdmin;
import com.example.bloodLink.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // getting all registeredSubAdmins
    @GetMapping("/get-registered-admins")
    public ResponseEntity<?> getAllRegisteredSubAdmin(){
        // get the email from security context and then call the superAdminService.findByEmail() to get the admin
        // and then fetch List<SubAdmin>

        //dummy email
        String email = "admin@gmail.com";
        SuperAdmin superAdmin = superAdminService.findByEmail(email);
        if (superAdmin == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SUPER_ADMIN NOT FOUND");

        }
        List<SubAdminDTO> subAdminDTOList = superAdmin.getListOfRegisteredAdmins()
                .stream()
                .map(SubAdminDTO::new)
                .toList();
        if (subAdminDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO REGISTERED SUB_ADMINS");
        }

        return ResponseEntity.ok(subAdminDTOList);

    }

    // function for accepting blood donation camps

    @PostMapping("/get-requested-camps")
    public ResponseEntity<?> getAllRequestedCamps()
    {
        return null;
    }


}
