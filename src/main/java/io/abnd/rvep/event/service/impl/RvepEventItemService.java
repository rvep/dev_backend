package io.abnd.rvep.event.service.impl;

import io.abnd.rvep.event.dao.intf.RvepEventDAO;
import io.abnd.rvep.event.dao.intf.RvepEventItemDAO;
import io.abnd.rvep.event.dao.intf.RvepEventProfileDAO;
import io.abnd.rvep.event.dao.intf.RvepLocationDAO;
import io.abnd.rvep.event.model.RvepEvent;
import io.abnd.rvep.event.model.RvepEventItem;
import io.abnd.rvep.event.model.RvepLocation;
import io.abnd.rvep.event.model.intf.AddEventItemRequest;
import io.abnd.rvep.event.service.intf.EventItemService;
import io.abnd.rvep.security.dao.intf.RvepUserEventRoleDAO;
import io.abnd.rvep.security.model.RvepUserEventRole;
import io.abnd.rvep.user.dao.intf.RvepUserProfileDAO;
import io.abnd.rvep.user.model.RvepUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Calendar;
import java.util.List;

@Service
public class RvepEventItemService implements EventItemService {

    private RvepUserProfileDAO rvepUserProfileDAO;
    private RvepEventProfileDAO rvepEventProfileDAO;
    private RvepEventItemDAO rvepEventItemDAO;
    private RvepUserEventRoleDAO rvepUserEventRoleDAO;
    private RvepLocationDAO rvepLocationDAO;

    private static final Logger logger = LoggerFactory.getLogger(RvepEventItemService.class);

    public RvepEventItemService(RvepUserProfileDAO rvepUserProfileDAO,
                                RvepEventProfileDAO rvepEventProfileDAO,
                                RvepEventItemDAO rvepEventItemDAO,
                                RvepUserEventRoleDAO rvepUserEventRoleDAO,
                                RvepLocationDAO rvepLocationDAO) {
        this.rvepUserProfileDAO = rvepUserProfileDAO;
        this.rvepEventProfileDAO = rvepEventProfileDAO;
        this.rvepEventItemDAO = rvepEventItemDAO;
        this.rvepUserEventRoleDAO = rvepUserEventRoleDAO;
        this.rvepLocationDAO = rvepLocationDAO;
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

    @Override
    @Transactional
    public RvepEventItem addEventItem(AddEventItemRequest addEventItemRequest) {
        // init return
        RvepEventItem rvepEventItem = new RvepEventItem();

        // get calendar
        Calendar cal = Calendar.getInstance();

        // get event
        RvepEvent rvepEvent = rvepEventProfileDAO.findByRvepEventId(addEventItemRequest.getEventId()).getRvepEvent();

        // create event location
        RvepLocation rvepLocation = new RvepLocation();
        rvepLocation.setTitle(addEventItemRequest.getLocationTitle());
        rvepLocation.setDescription(addEventItemRequest.getDescription());
        rvepLocation.setGeolat(addEventItemRequest.getLocationGeoLat());
        rvepLocation.setGeolng(addEventItemRequest.getLocationGeoLng());
        rvepLocation.setEnabled((byte)1);

        // create event item
        rvepEventItem.setTitle(addEventItemRequest.getTitle());
        rvepEventItem.setDescription(addEventItemRequest.getDescription());
        rvepEventItem.setDateTime(addEventItemRequest.getDateTime());
        rvepEventItem.setCreatedOn(cal.getTime());
        rvepEventItem.setUpdatedOn(rvepEventItem.getCreatedOn());
        rvepEventItem.setRvepEvent(rvepEvent);
        rvepEventItem.setRvepLocation(rvepLocation);
        rvepEventItem.setEnabled((byte)1);

        try {
            // store
            rvepLocationDAO.save(rvepLocation);
            rvepEventItemDAO.save(rvepEventItem);
        } catch(Exception e) {
            logger.error(e.getMessage());
            return null;
        }

        return rvepEventItem;
    }
}
