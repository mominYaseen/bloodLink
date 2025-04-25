package com.example.bloodLink.repository;

import com.example.bloodLink.modals.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity,Long> {
    UserEntity findUserByEmail(String email);
    List<UserEntity> findByBloodGroupAndEligibleToDonateTrue(String bloodGroup);
}
