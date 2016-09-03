package io.abnd.rvep.security.model.impl;

import io.abnd.rvep.security.model.intf.AuthToken;

public class FirebaseAuthToken implements AuthToken {

    private String idToken;

    public String getIdToken() {
        return this.idToken;
    }
    public void setIdToken(String idToken) { this.idToken = idToken; }

}
