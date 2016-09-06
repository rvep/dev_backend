package io.abnd.rvep.user.model.impl;

import io.abnd.rvep.user.model.intf.IsUserRegisteredResponse;

public class RvepIsUserRegisteredResponse implements IsUserRegisteredResponse {
    private boolean isRegistered;

    @Override
    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    @Override
    public boolean getIsRegistered() {
        return this.isRegistered;
    }
}
