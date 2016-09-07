package io.abnd.rvep.security.model.impl;

import io.abnd.rvep.security.model.intf.AuthVerificationResponse;

public class FirebaseAuthVerificationResponse implements AuthVerificationResponse {
    private boolean isVerified;
    private String idToken;

    @Override
    public boolean getIsVerified() { return this.isVerified; }
    @Override
    public String getIdToken() { return this.idToken; }

    @Override
    public void setIsVerified(boolean isVerified) { this.isVerified = isVerified; }
    @Override
    public void setIdToken(String idToken) { this.idToken = idToken; }

}
