package io.abnd.rvep.event.rest;

import io.abnd.rvep.event.model.impl.RvepAddEventRequest;
import io.abnd.rvep.event.model.impl.RvepAddEventResponse;
import io.abnd.rvep.event.service.impl.RvepAddEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/app/events")
public class EventRestController {

    private RvepAddEventService rvepAddEventService;

    public EventRestController(RvepAddEventService rvepAddEventService) {
        this.rvepAddEventService = rvepAddEventService;
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
        boolean eventAdded = this.rvepAddEventService.addEvent(request.getTitle(), request.getDescription(), request.getEmail());

        // set return val
        response.setIsAdded(eventAdded);

        // return
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
