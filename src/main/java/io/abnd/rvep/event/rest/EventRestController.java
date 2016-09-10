package io.abnd.rvep.event.rest;

import io.abnd.rvep.event.model.impl.RvepAddEventRequest;
import io.abnd.rvep.event.model.impl.RvepAddEventResponse;
import io.abnd.rvep.event.model.impl.RvepGetEventResponse;
import io.abnd.rvep.event.service.impl.RvepEventService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/app/events")
public class EventRestController {

    private RvepEventService rvepEventsService;

    public EventRestController(RvepEventService rvepEventsService) {
        this.rvepEventsService = rvepEventsService;
    }

    @ResponseBody
    @RequestMapping(value="/get/event/all",
                    method=RequestMethod.GET,
                    headers="Content-Type=application/json",
                    produces="application/json")
    public ResponseEntity<List<RvepGetEventResponse>>
    getAllEvents(@Param("email") String email) {
        // init response
        List<RvepGetEventResponse> response = new ArrayList<>();

        // get events
        this.rvepEventsService.getAllEvents(email).forEach(event -> {
            RvepGetEventResponse res = new RvepGetEventResponse();
            res.setEventId(event.getId());
            res.setDescription(event.getDescription());
            res.setTitle(event.getTitle());
            response.add(res);
        });

        // return
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value="/add/event",
                    method=RequestMethod.POST,
                    headers="Content-Type=application/json",
                    produces="application/json",
                    consumes="application/json")
    public ResponseEntity<RvepAddEventResponse>
    addEvent(@RequestBody RvepAddEventRequest request) {
        // init response
        RvepAddEventResponse response = new RvepAddEventResponse();

        // add event
        boolean eventAdded = this.rvepEventsService.addEvent(request.getTitle(), request.getDescription(), request.getEmail());

        // set return val
        response.setIsAdded(eventAdded);

        // return
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
