package io.abnd.rvep.user.model.intf;

public interface RegisterUserRequest {
    void setEmail(String email);
    void setProvider(String provider);
    String getEmail();
    String getProvider();
}
