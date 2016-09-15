package io.abnd.rvep.event.rest;

import io.abnd.rvep.event.model.RvepEventItem;
import io.abnd.rvep.event.model.impl.RvepAddEventItemRequest;
import io.abnd.rvep.event.model.impl.RvepAddEventItemResponse;
import io.abnd.rvep.event.model.impl.RvepGetEventItemResponse;
import io.abnd.rvep.event.service.impl.RvepEventItemService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/app/events/event/{profileId}/items")
public class EventItemRestController {

    private RvepEventItemService rvepEventItemService;

    public EventItemRestController(RvepEventItemService rvepEventItemService) {
        this.rvepEventItemService = rvepEventItemService;
    }

    @ResponseBody
    @RequestMapping(value="/add/item")
    public ResponseEntity<RvepAddEventItemResponse>
    addEventItem(@RequestBody RvepAddEventItemRequest rvepAddEventItemRequest) {
        // init response
        RvepAddEventItemResponse rvepAddEventItemResponse = new RvepAddEventItemResponse();

        RvepEventItem rvepEventItem = rvepEventItemService.addEventItem(rvepAddEventItemRequest);
        rvepAddEventItemResponse.setEventItemAdded(rvepEventItem != null ? true : false);

        // return
        return new ResponseEntity<RvepAddEventItemResponse>(rvepAddEventItemResponse, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value="/get/all",
            method=RequestMethod.GET,
            headers="Content-Type=application/json",
            produces="application/json")
    public ResponseEntity<List<RvepGetEventItemResponse>>
    getAllEventItems(@PathVariable String profileId, @Param("email") String email) {
        // init response
        List<RvepGetEventItemResponse> response = new ArrayList<>();

        this.rvepEventItemService.getAllEventItems(profileId, email)
            .forEach(rvepEventItem -> {
                RvepGetEventItemResponse res = new RvepGetEventItemResponse();
                res.setDescription(rvepEventItem.getDescription());
                res.setTitle(rvepEventItem.getTitle());
                res.setId(rvepEventItem.getId());
                response.add(res);
            });

        // return
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
