package ch.noseryoung.schnuppiBackend.domain.supervisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supervisors")
public class SupervisorController {
    SupervisorService supervisorService;

    @Autowired
    public SupervisorController(SupervisorService supervisorService) {
        this.supervisorService = supervisorService;
    }

    //getting database entry by id
    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Supervisor> getById(@PathVariable Long id){
        Optional<Supervisor> supervisor = supervisorService.findById(id);
        if (supervisor.isPresent()) {
            return new ResponseEntity<>(supervisor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting database entry by subject
    @GetMapping(value = {"", "/"}, params = "job")
    public @ResponseBody ResponseEntity<Supervisor> getByJob(@RequestParam("job") String job){
        Optional<Supervisor> supervisor = supervisorService.findByJobDescription(job);
        if (supervisor.isPresent()) {
            return new ResponseEntity<>(supervisor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting all database entries in entity
    @GetMapping({"", "/"})
    public @ResponseBody ResponseEntity<List<Supervisor>> getAll(){
        List<Supervisor> supervisors = supervisorService.findAll();
        if (!supervisors.isEmpty()) {
            return new ResponseEntity<>(supervisors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //create new supervisor
    @PostMapping({"", "/"})
    public @ResponseBody ResponseEntity<Supervisor> createSupervisor(@RequestBody Supervisor supervisor){
        supervisorService.save(supervisor);
        return new ResponseEntity<>(supervisor, HttpStatus.CREATED);
    }

    //delete supervisor by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Supervisor> deleteById(@PathVariable Long id) {
        supervisorService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update supervisor by id
    @PutMapping("/{id}")
    public ResponseEntity<Supervisor> updateById(@PathVariable Long id, @RequestBody Supervisor supervisor) {
        HttpStatus status = ((supervisorService.update(supervisor, id)) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(supervisor, status);
    }


}
