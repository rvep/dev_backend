package io.abnd.rvep.security.rest;

import io.abnd.rvep.security.model.impl.FirebaseAuthVerificationRequest;
import io.abnd.rvep.security.model.impl.FirebaseAuthVerificationResponse;
import io.abnd.rvep.security.model.intf.AuthVerificationResponse;
import io.abnd.rvep.security.service.impl.FirebaseAuthVerifier;
import io.abnd.rvep.security.service.impl.RvepJwtGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("/api/auth/firebase")
public class FirebaseAuthController {

    private FirebaseAuthVerifier fbAuthVerifier;
    private RvepJwtGenerator jwtGenerator;

    public FirebaseAuthController(FirebaseAuthVerifier fbAuthVerifier,
                                  RvepJwtGenerator jwtGenerator) {
        this.fbAuthVerifier = fbAuthVerifier;
        this.jwtGenerator = jwtGenerator;
    }

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
        boolean isVerified = this.fbAuthVerifier.verify(authToken.getIdToken());
        fbAuthVerificationResponse.setIsVerified(isVerified);

        // return json response
        ResponseEntity<AuthVerificationResponse> response =
                new ResponseEntity<>(fbAuthVerificationResponse, HttpStatus.OK);

        return response;
    }

}
