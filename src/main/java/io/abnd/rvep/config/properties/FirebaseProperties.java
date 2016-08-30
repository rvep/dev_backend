package io.abnd.rvep.config.properties;

import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
public class FirebaseProperties {

    @Value("${firebase.project_info.project_number}")
    private String projectNumber;

    @Value("${firebase.project_info.firebase_url}")
    private String firebaseUrl;

    @Value("${firebase.project_info.project_id}")
    private String projectId;

    @Value("${firebase.project_info.storage_bucket}")
    private String storageBucket;

    @Value("${firebase.client.oauth_client.client_id}")
    private String clientId;
    
    @Value("${firebase.client.api_key.current_key}")
    private String currentkey;

    public String getFirebaseUrl() { return this.firebaseUrl; }
    public String getProjectNumber() { return this.projectNumber; }
    public String getProjectId() { return this.projectId; }
    public String getStorageBucket() { return this.storageBucket; }
    public String getClientId() { return this.clientId; }
    public String getCurrentkey() { return this.currentkey; }
}
