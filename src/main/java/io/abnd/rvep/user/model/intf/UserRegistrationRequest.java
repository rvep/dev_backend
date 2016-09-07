package io.abnd.rvep.user.model.intf;

public interface UserRegistrationRequest {
    void setEmail(String email);
    void setProvider(String provider);
    void setIdToken(String idToken);

    String getEmail();
    String getProvider();
    String getIdToken();
}
