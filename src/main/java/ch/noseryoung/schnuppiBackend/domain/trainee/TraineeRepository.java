package ch.noseryoung.schnuppiBackend.domain.trainee;

import ch.noseryoung.schnuppiBackend.domain.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long>{
    Optional<Trainee> findByAge(String age);
    Optional<Trainee> findByuuid(String uuid);
}
