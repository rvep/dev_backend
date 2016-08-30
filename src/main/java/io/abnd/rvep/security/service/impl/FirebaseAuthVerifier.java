package io.abnd.rvep.security.service.impl;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.tasks.Task;
import io.abnd.rvep.security.model.intf.AuthToken;
import io.abnd.rvep.security.service.intf.AuthVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
public class FirebaseAuthVerifier implements AuthVerifier {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean verify(AuthToken token) throws GeneralSecurityException, IOException {
        Task<FirebaseToken> fbTask = FirebaseAuth.getInstance().verifyIdToken(token.getTokenId());

        fbTask.getResult();

        return fbTask.isSuccessful();
    }

}
