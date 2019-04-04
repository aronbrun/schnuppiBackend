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
    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Location> getById(@PathVariable Long id){
        Optional<Location> location = locationService.findById(id);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting database entry by address
    @GetMapping(value = {"", "/"}, params = "address")
    public @ResponseBody ResponseEntity<Location> getByAddress(@RequestParam("address") String address){
        Optional<Location> location = locationService.findByAddress(address);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting database entry by city
    @GetMapping(value = {"", "/"}, params = "city")
    public @ResponseBody ResponseEntity<Location> getByCity(@RequestParam("city") String city){
        Optional<Location> location = locationService.findByCity(city);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting database entry by country
    @GetMapping(value = {"", "/"}, params = "country")
    public @ResponseBody ResponseEntity<Location> getByCountry(@RequestParam("country") String country){
        Optional<Location> location = locationService.findByCountry(country);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting database entry by location
    @GetMapping(value = {"", "/"}, params = "location")
    public @ResponseBody ResponseEntity<Location> getByLocationName(@RequestParam("location_name") String location_name){
        Optional<Location> location = locationService.findByLocationName(location_name);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting database entry by postal code
    @GetMapping(value = {"", "/"}, params = "postal_code")
    public @ResponseBody ResponseEntity<Location> getByPostalCode(@RequestParam("postal_code") String postal_code){
        Optional<Location> location = locationService.findByPostalCode(postal_code);
        if (location.isPresent()) {
            return new ResponseEntity<>(location.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting all database entries in entity
    @GetMapping({"", "/"})
    public @ResponseBody ResponseEntity<List<Location>> getAll(){
        List<Location> locations = locationService.findAll();
        if (!locations.isEmpty()) {
            return new ResponseEntity<>(locations, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //create new Location
    @PostMapping({"", "/"})
    public @ResponseBody ResponseEntity<Location> createLocation(@RequestBody Location location){
        locationService.save(location);
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }

    //delete location by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Location> deleteById(@PathVariable Long id) {
        locationService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //update location by id
    @PutMapping("/{id}")
    public ResponseEntity<Location> updateById(@PathVariable Long id, @RequestBody Location location) {
        HttpStatus status = ((locationService.update(location, id)) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(location, status);
    }
}
