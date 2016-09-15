package io.abnd.rvep.event.model.impl;

import io.abnd.rvep.event.model.intf.AddEventItemResponse;

public class RvepAddEventItemResponse implements AddEventItemResponse {
    private boolean eventItemAdded;

    @Override
    public void setEventItemAdded(boolean eventItemAdded) {
        this.eventItemAdded = eventItemAdded;
    }

    @Override
    public boolean getEventItemAdded() {
        return this.eventItemAdded;
    }
}
