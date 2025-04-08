package com.example.bloodLink.repository;

import com.example.bloodLink.modals.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long> {
}
