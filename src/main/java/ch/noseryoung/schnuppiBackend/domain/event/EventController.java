package ch.noseryoung.schnuppiBackend.domain.event;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {
    EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    //getting database entry by name
    @GetMapping("/id/{id}")
    public @ResponseBody ResponseEntity<Event> getById(@PathVariable Long id){
        Optional<Event> event = eventService.findById(id);
        if (event.isPresent()) {
            return new ResponseEntity<>(event.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //getting all database entries in entity
    @GetMapping({"", "/"})
    public @ResponseBody ResponseEntity<List<Event>> getAll(@PathVariable Long id){
        List<Event> events = eventService.findAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(events, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //create new Event
    @PostMapping({"", "/"})
    public @ResponseBody ResponseEntity<Event> createEvent(@RequestBody Event event){
        eventService.save(event);
    }
}
