package io.abnd.rvep.user.model.impl;

import io.abnd.rvep.user.model.intf.UserRegistrationRequest;

public class RvepUserRegistrationRequest implements UserRegistrationRequest {

    private String email;
    private String provider;

    @Override
    public void setEmail(String email) { this.email = email; }
    @Override
    public void setProvider(String provider) { this.provider = provider; }

    @Override
    public String getEmail() { return this.email; }
    @Override
    public String getProvider() { return this.provider; }

}
