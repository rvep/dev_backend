package io.abnd.rvep.event.model.intf;

public interface AddEventRequest {
    void setTitle(String title);
    void setDescription(String description);
    void setEmail(String email);

    String getTitle();
    String getDescription();
    String getEmail();
}
