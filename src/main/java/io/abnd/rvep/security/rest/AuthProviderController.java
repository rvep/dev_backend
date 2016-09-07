package io.abnd.rvep.security.rest;

import io.abnd.rvep.security.model.AuthProvider;
import io.abnd.rvep.security.service.intf.AuthProviderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth/provider")
public class AuthProviderController {

    private AuthProviderService authProviderService;

    public AuthProviderController(AuthProviderService authProviderService) {
        this.authProviderService = authProviderService;
    }

    @ResponseBody
    @RequestMapping(path="/get/providers",
                    produces = "application/json")
    public ResponseEntity<List<AuthProvider>> getAuthProviders() {
        return new ResponseEntity<>(authProviderService
                .getAuthProviders(), HttpStatus.OK);
    }

}
