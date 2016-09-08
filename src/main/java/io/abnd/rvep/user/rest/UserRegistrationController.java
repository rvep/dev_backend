package io.abnd.rvep.user.rest;

import io.abnd.rvep.security.service.impl.RvepJwtGenerator;
import io.abnd.rvep.user.model.impl.RvepUserRegistrationRequest;
import io.abnd.rvep.user.model.impl.RvepUserRegistrationResponse;
import io.abnd.rvep.user.service.impl.RvepRegisterUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("/api/registration")
public class UserRegistrationController {

    private RvepRegisterUserService rvepRegisterUserService;
    private RvepJwtGenerator jwtGenerator;

    public UserRegistrationController(RvepRegisterUserService rvepRegisterUserService,
                                      RvepJwtGenerator jwtGenerator) {
        this.rvepRegisterUserService = rvepRegisterUserService;
        this.jwtGenerator = jwtGenerator;
    }

    @ResponseBody
    @RequestMapping(value="/register/user",
                    method=RequestMethod.POST,
                    headers="Content-Type=application/json",
                    consumes="application/json",
                    produces="application/json")
    public ResponseEntity<RvepUserRegistrationResponse>
    register(@RequestBody RvepUserRegistrationRequest request)
            throws GeneralSecurityException, IOException {
        // init response
        RvepUserRegistrationResponse registerUserResponse =
                new RvepUserRegistrationResponse();

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
                    request.getProvider());
            registerUserResponse.setIdToken(idToken);

        } else {
            // user already registered
            registerUserResponse.setIsRegistered(false);
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
        // init response
        RvepUserRegistrationResponse registerUserResponse =
                new RvepUserRegistrationResponse();

        boolean isRegistered = this.rvepRegisterUserService.isUserRegistered(request.getEmail());
        registerUserResponse.setIsRegistered(isRegistered);

        // generate rvep api idtoken
        if (isRegistered) {
            String idToken = jwtGenerator.generateIdToken(
                    request.getEmail(),
                    request.getProvider());
            registerUserResponse.setIdToken(idToken);
        }

        return new ResponseEntity<>(registerUserResponse, HttpStatus.OK);
    }

}
