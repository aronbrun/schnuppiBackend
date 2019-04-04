package ch.noseryoung.schnuppiBackend.domain.trainee;

import ch.noseryoung.schnuppiBackend.domain.event.Event;
import ch.noseryoung.schnuppiBackend.domain.parentClasses.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
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
    private Set<Event> events;

    public Trainee() {
    }

    public Trainee(String age, Set<Event> events) {
        this.age = age;
        this.uuid = UUID.randomUUID().toString();
        this.events = events;
    }

    public Trainee(Long id, String age, Set<Event> events) {
        this.id = id;
        this.age = age;
        this.uuid = UUID.randomUUID().toString();
        this.events = events;
    }
}
