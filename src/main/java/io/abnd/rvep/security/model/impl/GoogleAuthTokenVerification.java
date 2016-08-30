package io.abnd.rvep.security.model.impl;

import io.abnd.rvep.security.model.intf.AuthTokenVerification;

public class GoogleAuthTokenVerification implements AuthTokenVerification {
    private boolean isVerified;

    public boolean getIsVerified() { return this.isVerified; }
    public void setIsVerified(boolean isVerified) { this.isVerified = isVerified; }

}
