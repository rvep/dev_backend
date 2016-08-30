package io.abnd.rvep.security.service.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.ByteStreams;
import io.abnd.rvep.config.properties.FirebaseProperties;
import io.abnd.rvep.security.model.intf.AuthToken;
import io.abnd.rvep.security.service.intf.AuthVerifier;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.*;
import java.security.GeneralSecurityException;

@Service
public class FirebaseAuthVerifier implements AuthVerifier {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseAuthVerifier.class);

    @Autowired
    private FirebaseProperties fbProps;

    public boolean verify(AuthToken token) throws GeneralSecurityException, IOException {
        // get google credential
        InputStream stream = new FileInputStream("src/main/resources/service-account.json");
        ByteArrayOutputStream streamCopy = new ByteArrayOutputStream();
        ByteStreams.copy(stream, streamCopy);
        stream.close();

        GoogleCredential googleCredential = GoogleCredential.fromStream(
                new ByteArrayInputStream(streamCopy.toByteArray()),
                new NetHttpTransport(),
                GsonFactory.getDefaultInstance());

        try {
            Jwts.parser()
                    .setSigningKey(googleCredential.getServiceAccountPrivateKey())
                    .parse(token.getTokenId());
        } catch(Exception e) {
            // log
            logger.info("Firebase auth token verification error: ");
            logger.info(e.getMessage());
            // claims may have been tampered with
            return false;
        }

        return true;
    }

}
