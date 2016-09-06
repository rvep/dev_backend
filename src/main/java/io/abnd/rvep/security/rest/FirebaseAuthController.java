package io.abnd.rvep.security.rest;

import io.abnd.rvep.security.model.impl.FirebaseAuthToken;
import io.abnd.rvep.security.model.impl.FirebaseAuthTokenVerification;
import io.abnd.rvep.security.model.intf.AuthTokenVerification;
import io.abnd.rvep.security.service.impl.FirebaseAuthVerifier;
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

    @ResponseBody
    @RequestMapping(value="/verify",
                    method=RequestMethod.POST,
                    headers="Content-Type=application/json",
                    consumes="application/json",
                    produces="application/json")
    public ResponseEntity<AuthTokenVerification>
    verify(@RequestBody FirebaseAuthToken glAuthToken)
            throws GeneralSecurityException, IOException {
        // init return
        AuthTokenVerification fbAuthTokenVerification =
                new FirebaseAuthTokenVerification();

        // verify token
        boolean isVerified = this.fbAuthVerifier.verify(glAuthToken);
        fbAuthTokenVerification.setIsVerified(isVerified);

        // return json response
        ResponseEntity<AuthTokenVerification> response =
                new ResponseEntity<>(fbAuthTokenVerification, HttpStatus.OK);
        return response;
    }

}
