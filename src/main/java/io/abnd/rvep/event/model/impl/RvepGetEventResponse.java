package io.abnd.rvep.event.model.impl;

import io.abnd.rvep.event.model.intf.GetEventResponse;

public class RvepGetEventResponse implements GetEventResponse {

    private int eventId;
    private String title;
    private String description;

    @Override
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getEventId() {
        return this.eventId;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
