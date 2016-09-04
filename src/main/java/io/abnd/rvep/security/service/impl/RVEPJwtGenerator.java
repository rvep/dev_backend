package io.abnd.rvep.security.service.impl;

import io.abnd.rvep.security.service.intf.JwtGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class RVEPJwtGenerator implements JwtGenerator {
    @Override
    public String generateIdToken(String username) {
        // get user roles
        String roles = "";

        return Jwts.builder().setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey")
                .compact();
    }
}
