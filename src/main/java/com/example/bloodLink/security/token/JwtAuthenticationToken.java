package com.example.bloodLink.security.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import javax.security.auth.Subject;


public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private String token;

    public JwtAuthenticationToken(String token) {
        super(null);
        this.token = token;
        setAuthenticated(false);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return super.implies(subject);
    }
}
