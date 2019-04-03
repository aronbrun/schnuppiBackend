package ch.noseryoung.schnuppiBackend.domain.trainee;

import ch.noseryoung.schnuppiBackend.domain.parentClasses.Person;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Trainee extends Person {
    @Id
    @GeneratedValue

    @Column
    private String age;

    @Column
    private String uuid;


    // Creating a random UUID (Universally unique identifier).
    public void createUUID(){
        UUID uuid = java.util.UUID.randomUUID();
        this.uuid = uuid.toString();
    }


}
