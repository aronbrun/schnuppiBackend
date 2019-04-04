package ch.noseryoung.schnuppiBackend.domain.event;

import ch.noseryoung.schnuppiBackend.domain.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    //finding entry by id
    public Optional<Event>  findById(Long id){
        Optional<Event> event = eventRepository.findById(id);

        return  event;
    }

    //finding Event by name
    public Optional<Event>  findByName(String name){
        Optional<Event> event = eventRepository.findByName(name);

        return  event;
    }

    //finding entry by subject
    public Optional<Event>  findBySubject(String subject){
        Optional<Event> event = eventRepository.findBySubject(subject);

        return  event;
    }

    //finding all entries
    public List<Event>  findAll(){
        List<Event> event = eventRepository.findAll();

        return  event;
    }

    //creating new event
    public void save(Event event){
        eventRepository.save(event);

    }
    //delete event by id
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }


}
