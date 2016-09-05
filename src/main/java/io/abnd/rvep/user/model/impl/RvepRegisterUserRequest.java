package io.abnd.rvep.user.model.impl;

import io.abnd.rvep.user.model.intf.RegisterUserRequest;

public class RvepRegisterUserRequest implements RegisterUserRequest {
    private String username;
    private String provider;

    @Override
    public void setUsername(String username) { this.username = username; }

    @Override
    public void setProvider(String provider) { this.provider = provider; }

    @Override
    public String getUsername() { return this.username; }

    @Override
    public String getProvider() { return this.provider; }

}
