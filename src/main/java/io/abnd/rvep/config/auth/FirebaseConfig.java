package io.abnd.rvep.config.auth;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import io.abnd.rvep.config.properties.FirebaseProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Component
public class FirebaseConfig {
    private Logger logger = LoggerFactory.getLogger(FirebaseConfig.class);

    @Autowired
    private FirebaseProperties fbProps;

    public void init() throws FileNotFoundException {
        logger.info("FIREBASE INIT");

        // init firebase
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setServiceAccount(new FileInputStream("classpath:google-services.json"))
                .setDatabaseUrl(this.fbProps.getStorageBucket())
                .build();

        FirebaseApp.initializeApp(options);
    }

}
