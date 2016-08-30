package io.abnd.rvep.security.model.impl;

import io.abnd.rvep.security.model.intf.AuthToken;

public class FirebaseAuthToken implements AuthToken {

    private String tokenId;

    public String getTokenId() {
        return this.tokenId;
    }
    public void setTokenId(String tokenId) { this.tokenId = tokenId; }

}
