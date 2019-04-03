package ch.noseryoung.schnuppiBackend.domain.berufsbildner;

import ch.noseryoung.schnuppiBackend.domain.location.Location;
import ch.noseryoung.schnuppiBackend.domain.parentClasses.Person;

import javax.persistence.*;

@Entity
@Table
public class Supervisor extends Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String jobDescription;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
