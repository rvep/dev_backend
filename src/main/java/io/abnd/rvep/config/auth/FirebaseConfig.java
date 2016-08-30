package io.abnd.rvep.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.abnd.rvep.config.properties.FirebaseProperties;

@Component
public class FirebaseConfig {
    private Logger logger = LoggerFactory.getLogger(FirebaseConfig.class);

    @Autowired
    private FirebaseProperties fbProps;

    @PostConstruct
    public void init() throws FileNotFoundException {
        logger.info("FIREBASE INIT");

        // init firebase
        if (FirebaseApp.getApps().size() == 0) {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setServiceAccount(new FileInputStream("src/main/resources/service-account.json"))
                    .setDatabaseUrl(this.fbProps.getStorageBucket())
                    .build();

            FirebaseApp.initializeApp(options);
        }
    }

}
