package io.abnd.rvep.security.model.impl;

import io.abnd.rvep.security.model.intf.AuthTokenVerification;

public class FirebaseAuthTokenVerification implements AuthTokenVerification {
    private boolean isVerified;

    @Override
    public boolean getIsVerified() { return this.isVerified; }
    @Override
    public void setIsVerified(boolean isVerified) { this.isVerified = isVerified; }

}
