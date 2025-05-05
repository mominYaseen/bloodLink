package com.example.bloodLink.repository;

import com.example.bloodLink.modals.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRepo extends JpaRepository<AuthUser,Long> {
    Optional<AuthUser> findByEmail(String email);
}
