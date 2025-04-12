package com.example.bloodLink.repository;

import com.example.bloodLink.modals.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperAdminRepo extends JpaRepository<SuperAdmin , Long> {
    SuperAdmin findByEmail(String email);
}
