package ch.noseryoung.schnuppiBackend.domain.location;

import ch.noseryoung.schnuppiBackend.domain.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

        return location;
    }

    public Optional<Location> findByAddress(String address){
        Optional<Location> location = locationRepository.findByAdress(address);

        return location;
    }

    public Optional<Location> findByCity(String city){
        Optional<Location> location = locationRepository.findByCity(city);

        return location;
    }

    public Optional<Location> findByCountry(String country){
        Optional<Location> location = locationRepository.findByCountry(country);

        return location;
    }

    public Optional<Location> findByLocationName(String location_name){
        Optional<Location> location = locationRepository.findByLocationName(location_name);

        return location;
    }

    public Optional<Location> findByPostalCode(String postal_code){
        Optional<Location> location = locationRepository.findByPostalCode(postal_code);

        return location;
    }

    //finding all entries
    public List<Location> findAll(){
        List<Location> location = locationRepository.findAll();

        return location;
    }
}
