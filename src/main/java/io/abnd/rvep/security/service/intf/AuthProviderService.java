package io.abnd.rvep.security.service.intf;

import io.abnd.rvep.security.model.AuthProvider;

import java.util.List;

public interface AuthProviderService {

    List<AuthProvider> getAuthProviders();

}
