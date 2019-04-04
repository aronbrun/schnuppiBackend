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

    //getting database entry by id
    @GetMapping("/get/id/{id}")
    public @ResponseBody ResponseEntity<Location> getById(@PathVariable Long id){
        Optional<Location> location = locationService.findById(id);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting database entry by address
    @GetMapping("/get/address/{address}")
    public @ResponseBody ResponseEntity<Location> getByAddress(@PathVariable String address){
        Optional<Location> location = locationService.findByAddress(address);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting database entry by city
    @GetMapping("/get/city/{city}")
    public @ResponseBody ResponseEntity<Location> getByCity(@PathVariable String city){
        Optional<Location> location = locationService.findByCity(city);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting database entry by country
    @GetMapping("/get/country/{country}")
    public @ResponseBody ResponseEntity<Location> getByCountry(@PathVariable String country){
        Optional<Location> location = locationService.findByCountry(country);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting database entry by location
    @GetMapping("/get/location_name/{location_name}")
    public @ResponseBody ResponseEntity<Location> getByLocationName(@PathVariable String location_name){
        Optional<Location> location = locationService.findByLocationName(location_name);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting database entry by postal code
    @GetMapping("/get/postal_code/{postal_code}")
    public @ResponseBody ResponseEntity<Location> getByPostalCode(@PathVariable String postal_code){
        Optional<Location> location = locationService.findByPostalCode(postal_code);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting all database entries in entity
    @GetMapping({"/get/all", "/get/all/"})
    public @ResponseBody ResponseEntity<List<Location>> getAll(){
        List<Location> locations = locationService.findAll();
        if (!locations.isEmpty()) {
            return new ResponseEntity<>(locations, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
