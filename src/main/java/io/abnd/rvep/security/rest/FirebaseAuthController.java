package io.abnd.rvep.security.rest;

import io.abnd.rvep.security.model.impl.FirebaseAuthToken;
import io.abnd.rvep.security.model.impl.FirebaseAuthTokenVerification;
import io.abnd.rvep.security.model.intf.AuthTokenVerification;
import io.abnd.rvep.security.service.impl.FirebaseAuthVerifier;
import io.abnd.rvep.security.service.impl.RvepJwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("/api/auth/firebase")
public class FirebaseAuthController {

    @Autowired
    private FirebaseAuthVerifier fbAuthVerifier;
    @Autowired
    private RvepJwtGenerator jwtGenerator;

    @ResponseBody
    @RequestMapping(value="/verify",
                    method=RequestMethod.POST,
                    headers="Content-Type=application/json",
                    consumes="application/json",
                    produces="application/json")
    public ResponseEntity<AuthTokenVerification>
    verify(@RequestBody FirebaseAuthToken authToken)
            throws GeneralSecurityException, IOException {
        // init return
        AuthTokenVerification fbAuthTokenVerification =
                new FirebaseAuthTokenVerification();

        // verify token
        boolean isVerified = this.fbAuthVerifier.verify(authToken);
        fbAuthTokenVerification.setIsVerified(isVerified);

        // if verified get rvep api idToken
        if (isVerified) {
            String idToken = jwtGenerator.generateIdToken(authToken.getEmail(), authToken.getProvider(), authToken.getIdToken());
            fbAuthTokenVerification.setIdToken(idToken);
        }

        // return json response
        ResponseEntity<AuthTokenVerification> response =
                new ResponseEntity<>(fbAuthTokenVerification, HttpStatus.OK);
        return response;
    }

}
