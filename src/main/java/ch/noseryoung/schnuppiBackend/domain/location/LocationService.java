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

    public Optional<Location> findByAdress(String adress){
        Optional<Location> location = locationRepository.findByAdress(adress);

        return  location;
    }

    public Optional<Location> findByCity(String city){
        Optional<Location> location = locationRepository.findByCity(city);

        return  location;
    }

    public Optional<Location> findByCountry(String country){
        Optional<Location> location = locationRepository.findByCountry(country);

        return  location;
    }

    public Optional<Location> findByLocationName(String location_name){
        Optional<Location> location = locationRepository.findByLocationName(location_name);

        return  location;
    }

    public Optional<Location> findByPostalCode(String postal_code){
        Optional<Location> location = locationRepository.findByPostalCode(postal_code);

        return  location;
    }
}
