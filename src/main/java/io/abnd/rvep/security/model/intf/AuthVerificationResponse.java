package io.abnd.rvep.security.model.intf;

public interface AuthVerificationResponse {

    boolean getIsVerified();
    String getIdToken();

    void setIsVerified(boolean verified);
    void setIdToken(String idToken);

}