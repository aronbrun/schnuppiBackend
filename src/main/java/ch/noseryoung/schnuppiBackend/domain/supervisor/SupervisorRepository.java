package ch.noseryoung.schnuppiBackend.domain.supervisor;

import ch.noseryoung.schnuppiBackend.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Long>{
    Optional<Supervisor> findByJobDescription(String job);
}
