package com.example.bloodLink.service;

import com.example.bloodLink.modals.SubAdmin;
import com.example.bloodLink.modals.SuperAdmin;
import org.springframework.web.bind.annotation.RequestBody;

public interface SuperAdminService {
    SubAdmin registerSubAdmin(SubAdmin admin);
    SuperAdmin findByEmail(String email);
}
