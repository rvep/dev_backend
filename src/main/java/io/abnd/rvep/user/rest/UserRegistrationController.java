package io.abnd.rvep.user.rest;

import io.abnd.rvep.user.model.impl.RvepUserRegisteredCheckResponse;
import io.abnd.rvep.user.model.impl.RvepRegisterUserRequest;
import io.abnd.rvep.user.model.impl.RvepRegisterUserResponse;
import io.abnd.rvep.user.service.impl.RvepRegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/app/user/")
public class UserRegistrationController {

    @Autowired
    private RvepRegisterUserService rvepRegisterUserService;

    @ResponseBody
    @RequestMapping(value="/register",
                    method=RequestMethod.POST,
                    headers="Content-Type=application/json",
                    consumes="application/json",
                    produces="application/json")
    public ResponseEntity<RvepRegisterUserResponse>
    register(@RequestBody RvepRegisterUserRequest request) {
        RvepRegisterUserResponse registerUserResponse =
                new RvepRegisterUserResponse();

        if (!rvepRegisterUserService.isUserRegistered(request.getEmail())) {
            registerUserResponse.setUserRegistered(
                    rvepRegisterUserService
                            .registerUser(request.getEmail(),
                                    request.getProvider()));
        } else {
            registerUserResponse.setUserRegistered(false);
        }

        ResponseEntity<RvepRegisterUserResponse> response =
                new ResponseEntity<>(registerUserResponse, HttpStatus.OK);

        return response;
    }

    @ResponseBody
    @RequestMapping(value="/is/registered",
                    method=RequestMethod.GET,
                    headers="Content-Type=application/json",
                    produces="application/json")
    public ResponseEntity<RvepUserRegisteredCheckResponse>
    isUserRegistered(@RequestParam("email") String email) {
        RvepUserRegisteredCheckResponse rvepIsUserRegisteredResponse =
                new RvepUserRegisteredCheckResponse();

        rvepIsUserRegisteredResponse
                .setIsRegistered(
                        this.rvepRegisterUserService
                            .isUserRegistered(email));

        ResponseEntity<RvepUserRegisteredCheckResponse> response =
                new ResponseEntity<>(rvepIsUserRegisteredResponse,
                                     HttpStatus.OK);

        return response;
    }

}
