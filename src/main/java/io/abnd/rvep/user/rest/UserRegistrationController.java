package io.abnd.rvep.user.rest;

import io.abnd.rvep.security.service.impl.FirebaseAuthVerifier;
import io.abnd.rvep.security.service.impl.RvepJwtGenerator;
import io.abnd.rvep.user.model.impl.RvepUserRegistrationRequest;
import io.abnd.rvep.user.model.impl.RvepUserRegistrationResponse;
import io.abnd.rvep.user.service.impl.RvepRegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("/api/registration")
public class UserRegistrationController {

    @Autowired
    private RvepRegisterUserService rvepRegisterUserService;
    @Autowired
    private FirebaseAuthVerifier fbAuthVerifier;
    @Autowired
    private RvepJwtGenerator jwtGenerator;

    @ResponseBody
    @RequestMapping(value="/register/user",
                    method=RequestMethod.POST,
                    headers="Content-Type=application/json",
                    consumes="application/json",
                    produces="application/json")
    public ResponseEntity<RvepUserRegistrationResponse>
    register(@RequestBody RvepUserRegistrationRequest request)
            throws GeneralSecurityException, IOException {
        RvepUserRegistrationResponse registerUserResponse =
                new RvepUserRegistrationResponse();

        // verify firebase idtoken
        boolean fbAuthVerified = fbAuthVerifier.verify(request.getIdToken());

        // if verified
        if (fbAuthVerified) {
            // check if user is not registered
            if (!rvepRegisterUserService.isUserRegistered(request.getEmail())) {
                // register user
                registerUserResponse.setIsRegistered(
                        rvepRegisterUserService
                                .registerUser(request.getEmail(),
                                        request.getProvider()));

                // generate rvep api idtoken
                String idToken = jwtGenerator.generateIdToken(
                        request.getEmail(),
                        request.getProvider(),
                        request.getIdToken());
                registerUserResponse.setIdToken(idToken);

            } else {
                // user already registered
                registerUserResponse.setIsRegistered(false);
            }
        }

        ResponseEntity<RvepUserRegistrationResponse> response =
                new ResponseEntity<>(registerUserResponse, HttpStatus.OK);

        return response;
    }

    @ResponseBody
    @RequestMapping(value="/is/user/registered",
            method= RequestMethod.POST,
            headers="Content-Type=application/json",
            produces="application/json")
    public ResponseEntity<RvepUserRegistrationResponse>
    isUserRegistered(@RequestBody RvepUserRegistrationRequest request)
            throws GeneralSecurityException, IOException {
        RvepUserRegistrationResponse registerUserResponse =
                new RvepUserRegistrationResponse();

        // verify firebase idtoken
        boolean fbAuthVerified = fbAuthVerifier.verify(request.getIdToken());

        // if verified
        if (fbAuthVerified) {
            boolean isRegistered = this.rvepRegisterUserService.isUserRegistered(request.getEmail());
            registerUserResponse.setIsRegistered(isRegistered);

            // generate rvep api idtoken
            if (isRegistered) {
                String idToken = jwtGenerator.generateIdToken(
                        request.getEmail(),
                        request.getProvider(),
                        request.getIdToken());
                registerUserResponse.setIdToken(idToken);
            }
        }

        ResponseEntity<RvepUserRegistrationResponse> response =
                new ResponseEntity<>(registerUserResponse, HttpStatus.OK);

        return response;
    }

}
