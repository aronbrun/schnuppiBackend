package ch.noseryoung.schnuppiBackend.domain.event;

import ch.noseryoung.schnuppiBackend.domain.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    //finding all entries
    public List<Event>  findAll(){
        List<Event> event = eventRepository.findAll();

        return  event;
    }
    //finding Event by name
    public Optional<Event>  findByName(String name){
        Optional<Event> event = eventRepository.findByName(name);

        return  event;
    }
    //creating new Event
    public void save(Event event){
        eventRepository.save(event);

    }


}
