package io.abnd.rvep.security.service.impl;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.abnd.rvep.security.model.intf.AuthToken;
import io.abnd.rvep.security.service.intf.AuthVerifier;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Map;

@Service
public class FirebaseAuthVerifier implements AuthVerifier {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseAuthVerifier.class);
    private static final String pubKeyUrl = "https://www.googleapis.com/robot/v1/metadata/x509/securetoken@system.gserviceaccount.com";

    /**
     *
     * @param token
     * @return
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public boolean verify(AuthToken token) throws GeneralSecurityException, IOException {
        // get public keys
        JsonObject publicKeys = getPublicKeysJson();

        // verify count
        int size = publicKeys.entrySet().size();
        int count = 0;

        // get json object as map
        // loop map of keys finding one that verifies
        for (Map.Entry<String, JsonElement> entry: publicKeys.entrySet()) {
            // log
            logger.info("attempting jwt id token validation with: ");

            try {
                // trying next key
                count++;

                // get public key
                PublicKey publicKey = getPublicKey(entry);

                // validate claim set
                Jwts.parser().setSigningKey(publicKey).parse(token.getTokenId());

                // success, we can return
                return true;
            } catch(Exception e) {
                // log
                logger.info("Firebase id token verification error: ");
                logger.info(e.getMessage());
                // claims may have been tampered with
                // if this is the last key, return false
                if (count == size) {
                    return false;
                }
            }
        }

        // no jwt exceptions
        return true;
    }

    /**
     *
     * @param entry
     * @return
     * @throws GeneralSecurityException
     */
    private PublicKey getPublicKey(Map.Entry<String, JsonElement> entry) throws GeneralSecurityException {
        String publicKeyPem = entry.getValue().getAsString()
                .replaceAll("-----BEGIN (.*)-----", "")
                .replaceAll("-----END (.*)----", "")
                .replaceAll("\r\n", "")
                .replaceAll("\n", "")
                .trim();

        logger.info(publicKeyPem);

        // build public key
        byte [] decoded = Base64.getDecoder().decode(publicKeyPem);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(decoded);
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(x509KeySpec);

        return publicKey;
    }

    /**
     *
     * @return
     * @throws IOException
     */
    private JsonObject getPublicKeysJson() throws IOException {
        // get public keys
        URI uri = URI.create(pubKeyUrl);
        GenericUrl url = new GenericUrl(uri);
        HttpTransport http = new NetHttpTransport();
        HttpResponse response = http.createRequestFactory().buildGetRequest(url).execute();

        // store json from request
        String json = response.parseAsString();
        // disconnect
        response.disconnect();

        // parse json to object
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();

        return jsonObject;
    }

}
