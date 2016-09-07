package io.abnd.rvep.security.model.impl;

import io.abnd.rvep.security.model.intf.AuthToken;

public class FirebaseAuthToken implements AuthToken {

    private String idToken;
    private String email;
    private String provider;

    @Override
    public String getIdToken() {
        return this.idToken;
    }
    @Override
    public String getEmail() { return this.email; }
    @Override
    public String getProvider() { return this.provider; }

    @Override
    public void setIdToken(String idToken) { this.idToken = idToken; }
    @Override
    public void setEmail(String email) { this.email = email; }
    @Override
    public void setProvider(String provider) { this.provider = provider; }

}
