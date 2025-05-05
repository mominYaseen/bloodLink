package com.example.bloodLink.service.impl;

import com.example.bloodLink.modals.AuthUser;
import com.example.bloodLink.repository.AuthUserRepo;
import com.example.bloodLink.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserRepo authUserRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return authUserRepo.findByEmail(email)
                .orElseThrow(()->new RuntimeException("USER NOT FOUND"));
    }


    @Override
    public AuthUser saveToDb(AuthUser authUser) {
        return authUserRepo.save(authUser);
    }
}
