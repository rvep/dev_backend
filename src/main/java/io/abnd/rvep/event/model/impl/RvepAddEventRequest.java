package io.abnd.rvep.event.model.impl;

import io.abnd.rvep.event.model.intf.AddEventRequest;

public class RvepAddEventRequest implements AddEventRequest {

    private String title;
    private String description;
    private String email;

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getEmail() {
        return this.email;
    }
}
