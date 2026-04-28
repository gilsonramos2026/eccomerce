package com.ecomerce.backend.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nimbusds.oauth2.sdk.auth.Secret;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

   @Value("${jwt.secret}")
   private String secret;

   @Value("${jwt.expiration}")
   private long expiration;

   private SecretKey getSecretKey() {
      return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
   }

   public String generateToken(String email) {
      Date now = new Date();
      Date expireAt = new Date(now.getTime() + expiration);

      return Jwts.builder()
            .subject(email)
            .issuedAt(now)
            .expiration(expireAt)
            .signWith(getSecretKey())
            .compact();
   }

   public String extractEmail(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

   public boolean isValid(String token) {
      try {
         extractEmail(token);
         return true;
      } catch (Exception exception) {
         return false;
      }
   }
}
