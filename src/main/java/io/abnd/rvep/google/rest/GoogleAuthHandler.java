package io.abnd.rvep.google.rest;

import io.abnd.rvep.security.model.impl.GoogleAuthToken;
import io.abnd.rvep.security.model.impl.GoogleAuthTokenVerification;
import io.abnd.rvep.security.model.intf.AuthTokenVerification;
import io.abnd.rvep.security.service.impl.GoogleAuthVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("/api/google/auth")
public class GoogleAuthHandler {

    @Autowired
    private GoogleAuthVerifier glAuthVerifier;

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/verify", method = RequestMethod.POST, headers = "Content-Type=application/json", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AuthTokenVerification> verify(@RequestBody GoogleAuthToken glAuthToken) throws GeneralSecurityException, IOException {
        // init return
        AuthTokenVerification glAuthTokenVerification = new GoogleAuthTokenVerification();

        // verify token
        boolean isVerified = this.glAuthVerifier.verify(glAuthToken);
        glAuthTokenVerification.setIsVerified(isVerified);

        // return json response
        ResponseEntity<AuthTokenVerification> response = new ResponseEntity<>(glAuthTokenVerification, HttpStatus.OK);
        return response;
    }

}
