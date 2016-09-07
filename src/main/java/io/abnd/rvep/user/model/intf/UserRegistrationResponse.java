package io.abnd.rvep.user.model.intf;

public interface UserRegistrationResponse {
    void setIsRegistered(boolean isRegistered);
    void setIdToken(String idToken);
    boolean getIsRegistered();
    String getIdToken();
}
