package com.example.bloodLink.service.impl;

import com.example.bloodLink.modals.SubAdmin;
import com.example.bloodLink.repository.SubAdminRepo;
import com.example.bloodLink.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {

    @Autowired
    private SubAdminRepo subAdminRepo;


    @Override
    public SubAdmin registerSubAdmin(SubAdmin admin) {
        return subAdminRepo.save(admin);
    }
}
