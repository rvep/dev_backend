package io.abnd.rvep.event.service.intf;

import io.abnd.rvep.event.model.RvepEventItem;

import java.util.List;

public interface EventItemService {
    List<RvepEventItem> getAllEventItems(String eventProfileId, String email);
}
