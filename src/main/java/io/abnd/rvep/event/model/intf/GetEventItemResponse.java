package io.abnd.rvep.event.model.intf;

public interface GetEventItemResponse {
    void setId(int id);
    void setTitle(String title);
    void setDescription(String description);

    int getId();
    String getTitle();
    String getDescription();
}
