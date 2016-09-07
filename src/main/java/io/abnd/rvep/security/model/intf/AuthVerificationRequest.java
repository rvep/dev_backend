package io.abnd.rvep.security.model.intf;

public interface AuthVerificationRequest {

    String getIdToken();
    String getEmail();
    String getProvider();

    void setIdToken(String idToken);
    void setEmail(String email);
    void setProvider(String provider);
}
