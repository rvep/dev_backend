package io.abnd.rvep.user.service.impl;

import io.abnd.rvep.user.dao.intf.RvepUserProfileDAO;
import io.abnd.rvep.user.model.RvepUserProfile;
import io.abnd.rvep.user.service.intf.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RvepRegisterUserService implements RegisterUserService {

    @Autowired
    private RvepUserProfileDAO rvepUserProfileDAO;

    @Override
    public boolean isUserRegistered(String email) {
        RvepUserProfile rvepUserProfile = rvepUserProfileDAO.findByEmail(email);
        return rvepUserProfile != null;
    }

}
