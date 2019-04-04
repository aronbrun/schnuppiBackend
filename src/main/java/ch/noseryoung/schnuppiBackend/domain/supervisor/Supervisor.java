package ch.noseryoung.schnuppiBackend.domain.supervisor;

import ch.noseryoung.schnuppiBackend.domain.location.Location;
import ch.noseryoung.schnuppiBackend.domain.parentClasses.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table
@Getter @Setter
public class Supervisor extends Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String jobDescription;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Supervisor(){

    }
    public Supervisor(String jobDescription, Location location) {
        this.jobDescription = jobDescription;
        this.location = location;
    }

    public Supervisor(Long id, String jobDcription, Location location) {
        this.id = id;
        this.jobDescription = jobDescription;
        this.location = location;
    }
}


