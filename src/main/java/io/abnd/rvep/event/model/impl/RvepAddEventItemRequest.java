package io.abnd.rvep.event.model.impl;

import io.abnd.rvep.event.model.intf.AddEventItemRequest;

import java.util.Date;

public class RvepAddEventItemRequest implements AddEventItemRequest {
    private int eventId;
    private String title;
    private String description;
    private Date dateTime;
    private String locationTitle;
    private String locationDescription;
    private float locationGeoLat;
    private float locationGeoLng;

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
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public void setLocationTitle(String locationTitle) {
        this.locationTitle = locationTitle;
    }

    @Override
    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    @Override
    public void setLocatoinGeoLat(float geoLat) {
        this.locationGeoLat = geoLat;
    }

    @Override
    public void setLocationGeoLng(float geoLng) {
        this.locationGeoLng = geoLng;
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

    @Override
    public Date getDateTime() {
        return this.dateTime;
    }

    @Override
    public String getLocationTitle() {
        return this.locationTitle;
    }

    @Override
    public String getLocationDescription() {
        return this.locationDescription;
    }

    @Override
    public float getLocationGeoLat() {
        return this.locationGeoLat;
    }

    @Override
    public float getLocationGeoLng() {
        return this.locationGeoLng;
    }
}
