package io.abnd.rvep.event.model.impl;

import io.abnd.rvep.event.model.intf.GetEventItemResponse;

public class RvepGetEventItemResponse implements GetEventItemResponse {

    private int id;
    private String title;
    private String description;

    @Override
    public void setId(int id) {
        this.id = id;
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
    public int getId() {
        return this.id;
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
