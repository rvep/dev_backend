package io.abnd.rvep.event.service.intf;

import io.abnd.rvep.event.model.RvepEventProfile;

import java.util.List;

public interface EventsService {
    boolean addEvent(String title, String description, String email);
    List<RvepEventProfile> getAllEvents(String email);
}
