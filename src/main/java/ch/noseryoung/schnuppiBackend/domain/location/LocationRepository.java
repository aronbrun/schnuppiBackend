package ch.noseryoung.schnuppiBackend.domain.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{
    Optional<Location> findByAdress(String adress);
    Optional<Location> findByCity(String city);
    Optional<Location> findByCountry(String country);
    Optional<Location> findByLocationName(String location_name);
    Optional<Location> findByPostalCode(String postcal_code);
}
