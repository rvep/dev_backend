package io.abnd.rvep.user.model.impl;

import io.abnd.rvep.user.model.intf.RegisterUserRequest;

public class RvepRegisterUserRequest implements RegisterUserRequest {
    private String username;

    @Override
    public void setUsername(String username) { this.username = username; }
    @Override
    public String getUsername() { return this.username; }

}
