package io.abnd.rvep.user.model.impl;

import io.abnd.rvep.user.model.intf.UserRegistrationResponse;

public class RvepUserRegistrationResponse implements UserRegistrationResponse {
    private boolean isRegistered;
    private String idToken;

    @Override
    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }
    @Override
    public void setIdToken(String idToken) { this.idToken = idToken; }

    @Override
    public boolean getIsRegistered() {
        return this.isRegistered;
    }
    @Override
    public String getIdToken() { return this.idToken; }

}
