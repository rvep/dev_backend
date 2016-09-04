package io.abnd.rvep.user.model.impl;

import io.abnd.rvep.user.model.intf.RegisterUserResponse;

public class RvepRegisterUserResponse implements RegisterUserResponse {

    private String username;

    @Override
    public void setUsername(String username) { this.username = username; }
    @Override
    public String getUsername() { return this.username; }

}
