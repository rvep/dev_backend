package io.abnd.rvep.user.model.intf;

public interface RegisterUserRequest {
    void setUsername(String username);
    void setProvider(String provider);
    String getUsername();
    String getProvider();
}
