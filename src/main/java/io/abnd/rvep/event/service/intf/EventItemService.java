package io.abnd.rvep.event.service.intf;

import io.abnd.rvep.event.model.RvepEventItem;
import io.abnd.rvep.event.model.impl.RvepAddEventItemRequest;
import io.abnd.rvep.event.model.intf.AddEventItemRequest;

import java.util.List;

public interface EventItemService {
    List<RvepEventItem> getAllEventItems(String eventProfileId, String email);
    RvepEventItem addEventItem(AddEventItemRequest addEventItemRequest);
}
