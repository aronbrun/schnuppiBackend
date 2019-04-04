package ch.noseryoung.schnuppiBackend.domain.supervisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupervisorService {
    SupervisorRepository supervisorRepository;

    @Autowired
    public SupervisorService(SupervisorRepository supervisorRepository) {
        this.supervisorRepository = supervisorRepository;
    }

    //finding entry by id
    public Optional<Supervisor>  findById(Long id){
        Optional<Supervisor> supervisor = supervisorRepository.findById(id);

        return  supervisor;
    }

    //finding entry by job description
    public Optional<Supervisor>  findByJobDescription(String job){
        Optional<Supervisor> supervisor = supervisorRepository.findByJobDescription(job);

        return  supervisor;
    }

    //finding all entries
    public List<Supervisor>  findAll(){
        List<Supervisor> supervisors = supervisorRepository.findAll();

        return  supervisors;
    }

    //creating new supervisor
    public void save(Supervisor supervisor){
        supervisorRepository.save(supervisor);

    }
    //delete supervisor by id
    public void deleteById(Long id) {
        supervisorRepository.deleteById(id);
    }

    //update supervisor by id
    public boolean update(Supervisor supervisor, Long id) {
        Optional<Supervisor> currenSupervisor = supervisorRepository.findById(id);
        if (currenSupervisor.isPresent()) {
            supervisor.setId(id);
        } else {
            return false;
        }

        supervisorRepository.save(supervisor);
        return true;
    }


}
