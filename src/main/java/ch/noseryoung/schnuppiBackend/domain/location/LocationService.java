package ch.noseryoung.schnuppiBackend.domain.location;

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

    //finding entry by id
    public Optional<Location>  findById(Long id){
        Optional<Location> location = locationRepository.findById(id);

        return location;
    }

    //finding entry by address
    public Optional<Location> findByAddress(String address){
        Optional<Location> location = locationRepository.findByAddress(address);

        return location;
    }

    //finding entry by city
    public Optional<Location> findByCity(String city){
        Optional<Location> location = locationRepository.findByCity(city);

        return location;
    }

    //finding entry by country
    public Optional<Location> findByCountry(String country){
        Optional<Location> location = locationRepository.findByCountry(country);

        return location;
    }

    //finding entry by location
    public Optional<Location> findByLocationName(String location_name){
        Optional<Location> location = locationRepository.findByLocationName(location_name);

        return location;
    }

    //finding entry by postcal code
    public Optional<Location> findByPostalCode(String postal_code){
        Optional<Location> location = locationRepository.findByPostalCode(postal_code);

        return location;
    }

    //finding all entries
    public List<Location> findAll(){
        List<Location> location = locationRepository.findAll();

        return location;
    }

    //creating new location
    public void save(Location location){
        locationRepository.save(location);

    }
    //delete location by id
    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }

    //update location by id
    public boolean update(Location location, Long id) {
        Optional<Location> currentLocation = locationRepository.findById(id);
        if (currentLocation.isPresent()) {
            location.setId(id);
        } else {
            return false;
        }

        locationRepository.save(location);
        return true;
    }
}
