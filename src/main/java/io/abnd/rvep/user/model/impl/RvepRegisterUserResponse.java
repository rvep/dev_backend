package io.abnd.rvep.user.model.impl;

import io.abnd.rvep.user.model.intf.RegisterUserResponse;

public class RvepRegisterUserResponse implements RegisterUserResponse {

    private boolean userRegistered;

    @Override
    public void setUserRegistered(boolean userRegistered) { this.userRegistered = userRegistered; }
    @Override
    public boolean getUserRegistered() { return this.userRegistered; }

}
