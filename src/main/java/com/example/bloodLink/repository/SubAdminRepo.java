package com.example.bloodLink.repository;

import com.example.bloodLink.modals.SubAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubAdminRepo extends JpaRepository<SubAdmin, Long> {
    SubAdmin findByEmail(String email);
}
