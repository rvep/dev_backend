package io.abnd.rvep.event.service.impl;

import io.abnd.rvep.event.dao.intf.RvepEventDAO;
import io.abnd.rvep.event.dao.intf.RvepEventProfileDAO;
import io.abnd.rvep.event.model.RvepEvent;
import io.abnd.rvep.event.model.RvepEventProfile;
import io.abnd.rvep.event.service.intf.EventService;
import io.abnd.rvep.security.dao.intf.RvepRoleDAO;
import io.abnd.rvep.security.dao.intf.RvepUserEventRoleDAO;
import io.abnd.rvep.security.model.RvepRole;
import io.abnd.rvep.security.model.RvepUserEventRole;
import io.abnd.rvep.user.dao.intf.RvepUserProfileDAO;
import io.abnd.rvep.user.model.RvepUser;
import io.abnd.rvep.user.model.RvepUserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class RvepEventService implements EventService {

    private RvepEventDAO rvepEventDAO;
    private RvepEventProfileDAO rvepEventProfileDAO;
    private RvepUserProfileDAO rvepUserProfileDAO;
    private RvepRoleDAO rvepRoleDAO;
    private RvepUserEventRoleDAO rvepUserEventRoleDAO;
    private static final Logger logger = LoggerFactory.getLogger(RvepEventService.class);

    public RvepEventService(RvepEventDAO rvepEventDAO,
                            RvepEventProfileDAO rvepEventProfileDAO,
                            RvepUserProfileDAO rvepUserProfileDAO,
                            RvepRoleDAO rvepRoleDAO,
                            RvepUserEventRoleDAO rvepUserEventRoleDAO) {
        this.rvepEventDAO = rvepEventDAO;
        this.rvepEventProfileDAO = rvepEventProfileDAO;
        this.rvepUserProfileDAO = rvepUserProfileDAO;
        this.rvepRoleDAO = rvepRoleDAO;
        this.rvepUserEventRoleDAO = rvepUserEventRoleDAO;
    }



    @Override
    @Transactional
    public boolean addEvent(String title, String description, String email) {
        // get calendar
        Calendar cal = Calendar.getInstance();

        // create event
        RvepEvent event = new RvepEvent();
        event.setCreatedOn(cal.getTime());
        event.setEnabled((byte)1);

        // create event profile
        RvepEventProfile eventProfile = new RvepEventProfile();
        eventProfile.setTitle(title);
        eventProfile.setDescription(description);
        eventProfile.setCreatedOn(event.getCreatedOn());
        eventProfile.setUpdatedOn(event.getCreatedOn());
        eventProfile.setRvepEvent(event);
        eventProfile.setEnabled((byte)1);

        // get role
        RvepRole role = rvepRoleDAO.findByName("ROLE_CREATOR");

        // create rvep_user_event_role
        RvepUserProfile userProfile = this.rvepUserProfileDAO.findByEmail(email);
        RvepUserEventRole userEventRole = new RvepUserEventRole();
        userEventRole.setRvepEvent(event);
        userEventRole.setRvepUser(userProfile.getRvepUser());
        userEventRole.setRvepRole(role);

        // save
        try {
            this.rvepEventDAO.save(event);
            this.rvepEventProfileDAO.save(eventProfile);
            this.rvepUserEventRoleDAO.save(userEventRole);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public List<RvepEventProfile> getAllEvents(String email) {
        // get user id
        RvepUser user = this.rvepUserProfileDAO.findByEmail(email).getRvepUser();
        // get rvep user event role
        List<RvepUserEventRole> userEventRoles = this.rvepUserEventRoleDAO.findByRvepUserId(user.getId());

        // init return
        List<RvepEventProfile> eventProfiles = new ArrayList<>();
        userEventRoles.forEach((RvepUserEventRole role) -> {
            int eventId = role.getRvepEvent().getId();
            RvepEventProfile profile = this.rvepEventProfileDAO.findByRvepEventId(eventId);
            eventProfiles.add(profile);
        });

        return  eventProfiles;
    }

}
