package com.example.bloodLink.service;


import com.example.bloodLink.modals.AuthUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthUserService extends UserDetailsService {
    AuthUser saveToDb(AuthUser authUser);
    UserDetails loadUserByUsername(String email);

}
