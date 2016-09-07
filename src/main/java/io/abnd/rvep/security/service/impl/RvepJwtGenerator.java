package io.abnd.rvep.security.service.impl;

import io.abnd.rvep.security.dao.intf.RvepUserRoleDAO;
import io.abnd.rvep.security.model.RvepRole;
import io.abnd.rvep.security.model.RvepUserRole;
import io.abnd.rvep.security.service.intf.JwtGenerator;
import io.abnd.rvep.user.dao.intf.RvepUserProfileDAO;
import io.abnd.rvep.user.model.RvepUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RvepJwtGenerator implements JwtGenerator {
    @Autowired
    private RvepUserRoleDAO rvepUserRoleDAO;
    @Autowired
    private RvepUserProfileDAO rvepUserProfileDAO;

    @Override
    public String generateIdToken(String email, String provider, String firebaseIdToken) {
        // get user
        RvepUser user = rvepUserProfileDAO.findByEmail(email).getRvepUser();
        // get user role
        RvepUserRole userRole = rvepUserRoleDAO.findByRvepUserId(user.getId());
        // get role
        RvepRole role = userRole.getRvepRole();

        // return idToken
        return Jwts.builder().setSubject(email)
                .claim("provider", provider)
                .claim("firebaseIdToken", firebaseIdToken)
                .claim("role", role.getName())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey")
                .compact();
    }
}
