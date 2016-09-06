package io.abnd.rvep.user.rest;

import io.abnd.rvep.user.model.impl.RvepIsUserRegisteredResponse;
import io.abnd.rvep.user.model.impl.RvepRegisterUserRequest;
import io.abnd.rvep.user.model.impl.RvepRegisterUserResponse;
import io.abnd.rvep.user.service.impl.RvepRegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
public class UserRegistrationController {

    @Autowired
    private RvepRegisterUserService rvepRegisterUserService;

    @ResponseBody
    @RequestMapping(value="/register/user",
                    method=RequestMethod.POST,
                    headers="Content-Type=application/json",
                    consumes="application/json",
                    produces="application/json")
    public ResponseEntity<RvepRegisterUserResponse>
    register(RvepRegisterUserRequest request) {
        RvepRegisterUserResponse registerUserResponse =
                new RvepRegisterUserResponse();

        ResponseEntity<RvepRegisterUserResponse> response =
                new ResponseEntity<>(registerUserResponse, HttpStatus.OK);

        return response;
    }

    @ResponseBody
    @RequestMapping(value="/is/user/registered",
                    method=RequestMethod.GET,
                    headers="Content-Type=application/json",
                    produces="application/json")
    public ResponseEntity<RvepIsUserRegisteredResponse>
    isUserRegistered(@RequestParam("email") String email) {
        RvepIsUserRegisteredResponse rvepIsUserRegisteredResponse =
                new RvepIsUserRegisteredResponse();

        rvepIsUserRegisteredResponse
                .setIsRegistered(
                        this.rvepRegisterUserService
                            .isUserRegistered(email));

        ResponseEntity<RvepIsUserRegisteredResponse> response =
                new ResponseEntity<>(rvepIsUserRegisteredResponse,
                                     HttpStatus.OK);

        return response;
    }

}
