package ch.noseryoung.schnuppiBackend.domain.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {
    EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Optional<Event>  findById(Long id){
        Optional<Event> event = eventRepository.findById(id);

        return  event;
    }

    /*public Optional<Event>  findAll(){
        Optional<Event> event = eventRepository.findAll();

        return  event;
    }*/
}
