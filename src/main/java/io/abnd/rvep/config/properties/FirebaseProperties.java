package io.abnd.rvep.config.properties;

import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
public class FirebaseProperties {

    @Value("${firebase.project_info.project_number}")
    private String project_number;

    @Value("${firebase.project_info.firebase_url}")
    private String firebase_url;

    @Value("${firebase.project_info.project_id}")
    private String project_id;

    @Value("${firebase.project_info.storage_bucket}")
    private String storage_bucket;

    public String getFirebaseUrl() { return this.firebase_url; }
    public String getProjectNumber() { return this.project_number; }
    public String getProjectId() { return this.project_id; }
    public String getStorageBucket() { return this.storage_bucket; }
}
