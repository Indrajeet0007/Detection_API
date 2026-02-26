package com.Metron.DetectionAPI;

import com.Metron.DetectionAPI.enities.UserTable;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JWTUtility {
    private static final long Expiration_Time = 1000*60*60*10;
    private static final String key ="a-string-secret-at-least-256-bits-long";
    private static final SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes());

    public static String generateToken(String userName){
        return Jwts.builder()
                .setSubject(userName)
                .setExpiration( new Date(System.currentTimeMillis()+ Expiration_Time))
                .setIssuedAt(new Date())
                .signWith(secretKey , SignatureAlgorithm.HS256)
                .compact();
    }
    public static Claims extractClaim(String token){
        return Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public static  boolean validate (Claims claims, UserTable userTable){
            if(!claims.isEmpty()&& claims.getSubject().equals(userTable.userName) && claims.getExpiration().after(new Date())){
                return  true;
            }
                return false;
    }
}
