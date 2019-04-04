package ch.noseryoung.schnuppiBackend.domain.event;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    //getting database entry by id
    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Event> getById(@PathVariable Long id){
        Optional<Event> event = eventService.findById(id);
        if (event.isPresent()) {
            return new ResponseEntity<>(event.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting database entry by name
    @GetMapping(value = {"", "/"}, params = "name")
    public @ResponseBody ResponseEntity<Event> getByName(@RequestParam("name") String name){
        Optional<Event> event = eventService.findByName(name);
        if (event.isPresent()) {
            return new ResponseEntity<>(event.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting database entry by subject
    @GetMapping(value = {"", "/"}, params = "subject")
    public @ResponseBody ResponseEntity<Event> getBySubject(@RequestParam("subject") String subject){
        Optional<Event> event = eventService.findBySubject(subject);
        if (event.isPresent()) {
            return new ResponseEntity<>(event.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting all database entries in entity
    @GetMapping({"", "/"})
    public @ResponseBody ResponseEntity<List<Event>> getAll(){
        List<Event> events = eventService.findAll();
        if (!events.isEmpty()) {
            return new ResponseEntity<>(events, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //create new Event
    @PostMapping({"", "/"})
    public @ResponseBody ResponseEntity<Event> createEvent(@RequestBody Event event){
        eventService.save(event);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    //delete event by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Event> deleteById(@PathVariable Long id) {
        eventService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update event by id
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateById(@PathVariable Long id, @RequestBody Event event) {
        HttpStatus status = ((eventService.update(event, id)) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(event, status);
    }


}
