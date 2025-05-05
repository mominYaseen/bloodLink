package com.example.bloodLink.security.filters;

import com.example.bloodLink.dto.LoginRequest;
import com.example.bloodLink.security.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private JwtUtils jwtUtils;
    private AuthenticationManager authenticationManager;


    @Autowired
    public JwtAuthenticationFilter(JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException
    {

        if (!request.getServletPath().equals("/login")){
            filterChain.doFilter(request,response);
        }else{
            ObjectMapper objectMapper = new ObjectMapper();
            LoginRequest loginRequest = objectMapper.readValue(request.getInputStream(), LoginRequest.class);

//            System.out.println(loginRequest.getEmail().toString());

            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail() , loginRequest.getPassword());


            Authentication authResult = authenticationManager.authenticate(authToken);
            if (authResult.isAuthenticated()){
                String role = authResult.getAuthorities().iterator().next().getAuthority(); // Get the role
                String token = jwtUtils.generateToken(authResult.getName() ,role, 5);
                response.setHeader("Authorization" , "Bearer " + token);
            }
        }
    }
}

































