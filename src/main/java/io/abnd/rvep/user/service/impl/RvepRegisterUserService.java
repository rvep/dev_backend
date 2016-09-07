package io.abnd.rvep.user.service.impl;

import io.abnd.rvep.security.dao.intf.AuthProviderDAO;
import io.abnd.rvep.security.dao.intf.RvepRoleDAO;
import io.abnd.rvep.security.dao.intf.RvepUserAuthProviderDAO;
import io.abnd.rvep.security.dao.intf.RvepUserRoleDAO;
import io.abnd.rvep.security.model.AuthProvider;
import io.abnd.rvep.security.model.RvepRole;
import io.abnd.rvep.security.model.RvepUserAuthProvider;
import io.abnd.rvep.security.model.RvepUserRole;
import io.abnd.rvep.user.dao.intf.RvepUserDAO;
import io.abnd.rvep.user.dao.intf.RvepUserProfileDAO;
import io.abnd.rvep.user.model.RvepUser;
import io.abnd.rvep.user.model.RvepUserProfile;
import io.abnd.rvep.user.service.intf.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Autowired
    private RvepRoleDAO rvepRoleDAO;
    @Autowired
    private RvepUserRoleDAO rvepUserRoleDAO;

    @Override
    public boolean isUserRegistered(String email) {
        RvepUserProfile rvepUserProfile = rvepUserProfileDAO.findByEmail(email);
        return rvepUserProfile != null;
    }

    @Override
    @Transactional
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

        // create user role
        RvepRole role = rvepRoleDAO.findByName("ROLE_USER");
        RvepUserRole userRole = new RvepUserRole();
        userRole.setRvepUser(user);
        userRole.setRvepRole(role);

        try {
            rvepUserDAO.save(user);
            rvepUserProfileDAO.save(userProfile);
            rvepUserAuthProviderDAO.save(userAuthProvider);
            rvepUserRoleDAO.save(userRole);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
