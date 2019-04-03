package ch.noseryoung.schnuppiBackend.domain.location;

import ch.noseryoung.schnuppiBackend.domain.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {
    LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Optional<Location>  findById(Long id){
        Optional<Location> location = locationRepository.findById(id);

        return  location;
    }

    /*public Optional<Event>  findAll(){
        Optional<Event> event = eventRepository.findAll();

        return  event;
    }*/
}
