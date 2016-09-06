package io.abnd.rvep.user.service.impl;

import io.abnd.rvep.security.dao.intf.AuthProviderDAO;
import io.abnd.rvep.security.dao.intf.RvepUserAuthProviderDAO;
import io.abnd.rvep.security.model.AuthProvider;
import io.abnd.rvep.security.model.RvepUserAuthProvider;
import io.abnd.rvep.user.dao.intf.RvepUserDAO;
import io.abnd.rvep.user.dao.intf.RvepUserProfileDAO;
import io.abnd.rvep.user.model.RvepUser;
import io.abnd.rvep.user.model.RvepUserProfile;
import io.abnd.rvep.user.service.intf.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class RvepRegisterUserService implements RegisterUserService {

    @Autowired
    private RvepUserProfileDAO rvepUserProfileDAO;
    @Autowired
    private AuthProviderDAO authProviderDAO;
    @Autowired
    private RvepUserDAO rvepUserDAO;
    @Autowired
    private RvepUserAuthProviderDAO rvepUserAuthProviderDAO;

    @Override
    public boolean isUserRegistered(String email) {
        RvepUserProfile rvepUserProfile = rvepUserProfileDAO.findByEmail(email);
        return rvepUserProfile != null;
    }

    @Override
    public boolean registerUser(String email, String provider) {
        Calendar cal = Calendar.getInstance();

        // create user
        RvepUser user = new RvepUser();
        user.setCreatedOn(cal.getTime());
        user.setEnabled((byte)1);

        // create user profile
        RvepUserProfile userProfile = new RvepUserProfile();
        userProfile.setEmail(email);
        userProfile.setRvepUser(user);
        userProfile.setLastLogin(user.getCreatedOn());

        // create user auth provider
        AuthProvider authProvider = authProviderDAO.findByName(provider);
        RvepUserAuthProvider userAuthProvider = new RvepUserAuthProvider();
        userAuthProvider.setRvepUser(user);
        userAuthProvider.setAuthProvider(authProvider);

        // commit
        try {
            rvepUserDAO.save(user);
            rvepUserProfileDAO.save(userProfile);
            rvepUserAuthProviderDAO.save(userAuthProvider);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
