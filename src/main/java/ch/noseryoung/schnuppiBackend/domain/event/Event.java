package ch.noseryoung.schnuppiBackend.domain.event;

import ch.noseryoung.schnuppiBackend.domain.location.Location;
import ch.noseryoung.schnuppiBackend.domain.supervisor.Supervisor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
@Getter @Setter
public class Event {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn
    private Location location;

    @Column
    private LocalDate dateTime;

    @Column
    private String subject;

    @ManyToMany
    @JoinTable
    private Supervisor supervisor;

    public Event(String name, Location location, LocalDate dateTime, String subject, Supervisor supervisor) {
        this.name = name;
        this.location = location;
        this.dateTime = dateTime;
        this.subject = subject;
        this.supervisor = supervisor;
    }
    public Event(Long id, String name, Location location, LocalDate dateTime, String subject, Supervisor supervisor) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.dateTime = dateTime;
        this.subject = subject;
        this.supervisor = supervisor;
    }
}
