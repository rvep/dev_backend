package io.abnd.rvep.event.model.intf;


public interface GetEventResponse {
    void setEventId(int eventId);
    void setTitle(String title);
    void setDescription(String description);

    int getEventId();
    String getTitle();
    String getDescription();
}
