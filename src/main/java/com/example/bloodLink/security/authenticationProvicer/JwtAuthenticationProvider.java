package com.example.bloodLink.security.authenticationProvicer;

import com.example.bloodLink.security.token.JwtAuthenticationToken;
import com.example.bloodLink.security.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class JwtAuthenticationProvider implements AuthenticationProvider {

    private JwtUtils jwtUtils;
    private UserDetailsService userDetailsService;

    public JwtAuthenticationProvider(JwtUtils jwtUtils, UserDetailsService userDetailsService) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String token = ((JwtAuthenticationToken) authentication).getToken();

        String username = jwtUtils.validateAndExtractUsername(token);
//        System.out.println(token);
//        System.out.println(username);
        if (username == null) {
            throw new BadCredentialsException("Invalid JWT Token");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());



    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }

    public JwtUtils getJwtUtils() {
        return jwtUtils;
    }

    public void setJwtUtils(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}