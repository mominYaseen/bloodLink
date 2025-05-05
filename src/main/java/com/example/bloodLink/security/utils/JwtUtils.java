package com.example.bloodLink.security.utils;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    private static final String SECRET_KEY_STRING = "genie#1123122@@@323242323121qsadsdsd"; // ✅ looks fine
    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes(StandardCharsets.UTF_8));



    public String generateToken(String username,String role, long expiryInMinutes) {

        return Jwts.builder()
                .setSubject(username)
                .claim("role",role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiryInMinutes * 60 *1000)) //in milliseconds
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

    }


    public String validateAndExtractUsername(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (JwtException e) {
            return null; // Invalid or expired JWT
        }
    }

}