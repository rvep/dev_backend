package io.abnd.rvep.security.service.impl;

import io.abnd.rvep.security.model.intf.AuthToken;
import io.abnd.rvep.security.service.intf.AuthVerifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
public class GoogleAuthVerifier implements AuthVerifier {

    public boolean verify(AuthToken token) throws GeneralSecurityException, IOException {
        //FirebaseConfig.getInstance().verifyIdToken(token.getTokenId());
        return false;
        // return
        //return idToken != null;
    }

}
