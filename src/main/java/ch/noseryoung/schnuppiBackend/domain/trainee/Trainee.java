package ch.noseryoung.schnuppiBackend.domain.trainee;

import ch.noseryoung.schnuppiBackend.domain.event.Event;
import ch.noseryoung.schnuppiBackend.domain.parentClasses.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table
@Getter @Setter
public class Trainee extends Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String age;

    @Column
    private String uuid;

    @ManyToMany
    @JoinTable
    private Event event;

    // Creating a random UUID (Universally unique identifier).
    public void createUUID(){
        UUID uuid = java.util.UUID.randomUUID();
        this.uuid = uuid.toString();
    }


}
