package io.abnd.rvep.security.service.intf;

import io.abnd.rvep.security.model.intf.AuthVerificationRequest;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface AuthVerifier {

    boolean verify(String idToken) throws GeneralSecurityException, IOException;

}
