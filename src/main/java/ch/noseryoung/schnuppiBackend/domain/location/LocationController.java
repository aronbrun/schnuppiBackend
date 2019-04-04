package ch.noseryoung.schnuppiBackend.domain.location;

import ch.noseryoung.schnuppiBackend.domain.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationController {
    LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/id/{id}")
    public @ResponseBody ResponseEntity<Location> getById(@PathVariable Long id){
        Optional<Location> location = locationService.findById(id);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/adress/{adress}")
    public @ResponseBody ResponseEntity<Location> getByAdress(@PathVariable String adress){
        Optional<Location> location = locationService.findByAdress(adress);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/city/{city}")
    public @ResponseBody ResponseEntity<Location> getByCity(@PathVariable String city){
        Optional<Location> location = locationService.findByCity(city);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/country/{country}")
    public @ResponseBody ResponseEntity<Location> getByCountry(@PathVariable String country){
        Optional<Location> location = locationService.findByCountry(country);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/location_name/{location_name}")
    public @ResponseBody ResponseEntity<Location> getByLocationName(@PathVariable String location_name){
        Optional<Location> location = locationService.findByLocationName(location_name);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/postal_code/{postal_code}")
    public @ResponseBody ResponseEntity<Location> getByPostalCode(@PathVariable String postal_code){
        Optional<Location> location = locationService.findByPostalCode(postal_code);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting all database entries in entity
    @GetMapping({"", "/"})
    public @ResponseBody ResponseEntity<List<Location>> getAll(@PathVariable Long id){
        List<Location> locations = locationService.findAll();
        if (locations.isEmpty()) {
            return new ResponseEntity<>(locations, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
