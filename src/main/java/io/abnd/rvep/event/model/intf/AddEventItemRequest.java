package io.abnd.rvep.event.model.intf;

import java.util.Date;

public interface AddEventItemRequest {
    void setEventId(int eventId);
    void setTitle(String title);
    void setDescription(String description);
    void setDateTime(Date dateTime);
    void setLocationTitle(String locationTitle);
    void setLocationDescription(String locationDescription);
    void setLocatoinGeoLat(float geoLat);
    void setLocationGeoLng(float geoLng);

    int getEventId();
    String getTitle();
    String getDescription();
    Date getDateTime();
    String getLocationTitle();
    String getLocationDescription();
    float getLocationGeoLat();
    float getLocationGeoLng();
}
