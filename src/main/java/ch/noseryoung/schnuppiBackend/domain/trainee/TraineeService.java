package ch.noseryoung.schnuppiBackend.domain.trainee;

import ch.noseryoung.schnuppiBackend.domain.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeService {
    TraineeRepository traineeRepository;

    @Autowired
    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    //finding entry by id
    public Optional<Trainee>  findById(Long id){
        Optional<Trainee> trainee = traineeRepository.findById(id);

        return trainee;
    }

    //finding entry by age
    public Optional<Trainee> findByAge(String age){
        Optional<Trainee> trainee = traineeRepository.findByAge(age);

        return trainee;
    }

    //finding entry by uuid
    public Optional<Trainee> findByUUID(String UUID){
        Optional<Trainee> trainee = traineeRepository.findByuuid(UUID);

        return trainee;
    }

    //finding all entries
    public List<Trainee> findAll(){
        List<Trainee> trainee = traineeRepository.findAll();

        return trainee;
    }

    //creating new trainee
    public void save(Trainee trainee){
        traineeRepository.save(trainee);

    }
    //delete trainee by id
    public void deleteById(Long id) {
        traineeRepository.deleteById(id);
    }

    //update trainee by id
    public boolean update(Trainee trainee, Long id) {
        Optional<Trainee> currentTrainee = traineeRepository.findById(id);
        if (currentTrainee.isPresent()) {
            trainee.setId(id);
        } else {
            return false;
        }

        traineeRepository.save(trainee);
        return true;
    }
}
