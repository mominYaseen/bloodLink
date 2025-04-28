package com.example.bloodLink.service.impl;

import com.example.bloodLink.modals.BloodBankCenter;
import com.example.bloodLink.modals.SubAdmin;
import com.example.bloodLink.modals.SuperAdmin;
import com.example.bloodLink.repository.SubAdminRepo;
import com.example.bloodLink.repository.SuperAdminRepo;
import com.example.bloodLink.service.BloodBankCenterService;
import com.example.bloodLink.service.SubAdminService;
import com.example.bloodLink.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {


    @Autowired
    private SubAdminService subAdminService;

    @Autowired
    private SuperAdminRepo superAdminRepo;

    @Autowired
    private BloodBankCenterService bloodBankCenterService;

    @Override
    public SubAdmin registerSubAdmin(SubAdmin admin) {
        SuperAdmin superAdmin = superAdminRepo.findById(1l)
                .orElseThrow(()->new RuntimeException("SUPER_ADMIN NOT FOUND"));
        admin.setSuperAdmin(superAdmin);
        return subAdminService.registerSubAdmin(admin);
    }

    @Override
    public SuperAdmin findByEmail(String email) {
        SuperAdmin superAdmin = superAdminRepo.findByEmail(email);
        return superAdmin;
    }




}
