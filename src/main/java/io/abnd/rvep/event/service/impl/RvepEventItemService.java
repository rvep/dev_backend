package io.abnd.rvep.event.service.impl;

import io.abnd.rvep.event.dao.intf.RvepEventItemDAO;
import io.abnd.rvep.event.dao.intf.RvepEventProfileDAO;
import io.abnd.rvep.event.model.RvepEvent;
import io.abnd.rvep.event.model.RvepEventItem;
import io.abnd.rvep.event.service.intf.EventItemService;
import io.abnd.rvep.security.dao.intf.RvepUserEventRoleDAO;
import io.abnd.rvep.security.model.RvepUserEventRole;
import io.abnd.rvep.user.dao.intf.RvepUserProfileDAO;
import io.abnd.rvep.user.model.RvepUser;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RvepEventItemService implements EventItemService {

    private RvepUserProfileDAO rvepUserProfileDAO;
    private RvepEventProfileDAO rvepEventProfileDAO;
    private RvepEventItemDAO rvepEventItemDAO;
    private RvepUserEventRoleDAO rvepUserEventRoleDAO;

    public RvepEventItemService(RvepUserProfileDAO rvepUserProfileDAO,
                                RvepEventProfileDAO rvepEventProfileDAO,
                                RvepEventItemDAO rvepEventItemDAO,
                                RvepUserEventRoleDAO rvepUserEventRoleDAO) {
        this.rvepUserProfileDAO = rvepUserProfileDAO;
        this.rvepEventProfileDAO = rvepEventProfileDAO;
        this.rvepEventItemDAO = rvepEventItemDAO;
        this.rvepUserEventRoleDAO = rvepUserEventRoleDAO;
    }

    @Override
    public List<RvepEventItem> getAllEventItems(String eventProfileId, String email) {
        // get user id
        RvepUser user = this.rvepUserProfileDAO.findByEmail(email).getRvepUser();

        // get event
        RvepEvent event = rvepEventProfileDAO
                .findById(Integer.valueOf(eventProfileId).intValue())
                .getRvepEvent();

        // get user event roles
        List<RvepUserEventRole> rvepUserEventRoles = this.rvepUserEventRoleDAO
                .findByRvepUserIdAndRvepEventId(user.getId(), event.getId());

        // check if user has roles for the event
        if (rvepUserEventRoles.size() > 0) {
            return this.rvepEventItemDAO.findByRvepEventId(event.getId());
        }

        // no access found, throw exception
        throw new EntityNotFoundException();
    }
}
