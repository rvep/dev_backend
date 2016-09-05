package io.abnd.rvep.security.service.impl;

import io.abnd.rvep.security.dao.intf.AuthProviderDAO;
import io.abnd.rvep.security.model.AuthProvider;
import io.abnd.rvep.security.service.intf.AuthProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RVEPAuthProviderService implements AuthProviderService {
    @Autowired
    private AuthProviderDAO authProviderDAO;

    @Override
    public List<AuthProvider> getAuthProviders() {
        return authProviderDAO.findAll();
    }

}
