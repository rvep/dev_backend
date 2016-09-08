package io.abnd.rvep.event.model.impl;

import io.abnd.rvep.event.model.intf.AddEventResponse;

public class RvepAddEventResponse implements AddEventResponse {

    private boolean isAdded;

    @Override
    public void setIsAdded(boolean isAdded) {
        this.isAdded = isAdded;
    }

    @Override
    public boolean getIsAdded() {
        return this.isAdded;
    }
}
