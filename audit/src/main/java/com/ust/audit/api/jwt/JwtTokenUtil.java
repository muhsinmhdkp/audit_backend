package com.ust.audit.api.jwt;


import com.ust.audit.api.user.UstUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;

    @Value("${ust.jwt.secret}")
    private String secretKey;

    public String generateAccessToken(UstUser user) {
        return Jwts.builder().setSubject(user.getId() + "," +
                        user.getEmail())
                .setIssuer("ust")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS256, secretKey).compact();
    }
}

