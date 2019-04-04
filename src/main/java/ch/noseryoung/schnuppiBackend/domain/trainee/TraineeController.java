package ch.noseryoung.schnuppiBackend.domain.trainee;

import ch.noseryoung.schnuppiBackend.domain.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainees")
public class TraineeController {
    TraineeService traineeService;

    @Autowired
    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    //getting database entry by id
    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Trainee> getById(@PathVariable Long id){
        Optional<Trainee> trainee = traineeService.findById(id);
        if (trainee.isPresent()) {
            return new ResponseEntity<>(trainee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting database entry by age
    @GetMapping(value = {"", "/"}, params = "age")
    public @ResponseBody ResponseEntity<Trainee> getByAge(@RequestParam("age") String age){
        Optional<Trainee> trainee = traineeService.findByAge(age);
        if (trainee.isPresent()) {
            return new ResponseEntity<>(trainee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting database entry by uuid
    @GetMapping(value = {"", "/"}, params = "uuid")
    public @ResponseBody ResponseEntity<Trainee> getByUUID(@RequestParam("uuid") String uuid){
        Optional<Trainee> trainee = traineeService.findByUUID(uuid);
        if (trainee.isPresent()) {
            return new ResponseEntity<>(trainee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting all database entries in entity
    @GetMapping({"", "/"})
    public @ResponseBody ResponseEntity<List<Trainee>> getAll(){
        List<Trainee> trainee = traineeService.findAll();
        if (!trainee.isEmpty()) {
            return new ResponseEntity<>(trainee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //create new Trainee
    @PostMapping({"", "/"})
    public @ResponseBody ResponseEntity<Trainee> createTrainee(@RequestBody Trainee trainee){
        traineeService.save(trainee);
        return new ResponseEntity<>(trainee, HttpStatus.CREATED);
    }

    //delete Trainee by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Trainee> deleteById(@PathVariable Long id) {
        traineeService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //update Trainee by id
    @PutMapping("/{id}")
    public ResponseEntity<Trainee> updateById(@PathVariable Long id, @RequestBody Trainee trainee) {
        HttpStatus status = ((traineeService.update(trainee, id)) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(trainee, status);
    }
}
