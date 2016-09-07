package io.abnd.rvep.security.rest;

import io.abnd.rvep.security.model.impl.FirebaseAuthVerificationRequest;
import io.abnd.rvep.security.model.impl.FirebaseAuthVerificationResponse;
import io.abnd.rvep.security.model.intf.AuthVerificationResponse;
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
    public ResponseEntity<AuthVerificationResponse>
    verify(@RequestBody FirebaseAuthVerificationRequest authToken)
            throws GeneralSecurityException, IOException {
        // init return
        AuthVerificationResponse fbAuthVerificationResponse =
                new FirebaseAuthVerificationResponse();

        // verify token
        boolean isVerified = this.fbAuthVerifier.verify(authToken);
        fbAuthVerificationResponse.setIsVerified(isVerified);

        // if verified get rvep api idToken
        if (isVerified) {
            String idToken = jwtGenerator.generateIdToken(authToken.getEmail(), authToken.getProvider(), authToken.getIdToken());
            fbAuthVerificationResponse.setIdToken(idToken);
        }

        // return json response
        ResponseEntity<AuthVerificationResponse> response =
                new ResponseEntity<>(fbAuthVerificationResponse, HttpStatus.OK);
        return response;
    }

}
