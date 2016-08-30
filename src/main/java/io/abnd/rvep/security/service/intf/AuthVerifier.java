package io.abnd.rvep.security.service.intf;

import io.abnd.rvep.security.model.intf.AuthToken;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface AuthVerifier {

    boolean verify(AuthToken token) throws GeneralSecurityException, IOException;

}
