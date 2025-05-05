package com.example.bloodLink.security.filters;

import com.example.bloodLink.security.token.JwtAuthenticationToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtValidationFilter extends OncePerRequestFilter {

    private  final AuthenticationManager authenticationManager ;

    public JwtValidationFilter(AuthenticationManager authenticationManager ) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException
    {

        String token = extractToken(request);
        System.out.println(token);
        if (token !=null){
            JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(token);
            Authentication authResult = authenticationManager.authenticate(jwtAuthenticationToken);
            if (authResult.isAuthenticated()){
                SecurityContextHolder.getContext().setAuthentication(authResult);
            }
        }

        filterChain.doFilter(request,response);


    }

    private String extractToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        System.out.println(bearerToken);
        if (bearerToken!=null && bearerToken.startsWith("Bearer ")){
            String token = bearerToken.substring(7);
            System.out.println(token);
            return token;
        }
        return null;
    }

}
