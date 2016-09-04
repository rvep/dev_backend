package io.abnd.rvep.user.rest;

import io.abnd.rvep.user.model.impl.RvepRegisterUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/app/user")
public class UserRegistrationController {

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/register", method = RequestMethod.POST, headers = "Content-Type=application/json", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RvepRegisterUserResponse> verify() {
        RvepRegisterUserResponse registerUserResponse =
                new RvepRegisterUserResponse();

        ResponseEntity<RvepRegisterUserResponse> res =
                new ResponseEntity<>(registerUserResponse, HttpStatus.OK);

        return res;
    }

}
