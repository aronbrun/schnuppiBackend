package ch.noseryoung.schnuppiBackend.domain.event;

import ch.noseryoung.schnuppiBackend.domain.location.Location;
import ch.noseryoung.schnuppiBackend.domain.supervisor.Supervisor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "event_supervisor",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "supervisor_id")
    )
    private Set<Supervisor> supervisor;

    public Event() {
    }

    public Event(String name, Location location, LocalDate dateTime, String subject, Set<Supervisor> supervisor) {
        this.name = name;
        this.location = location;
        this.dateTime = dateTime;
        this.subject = subject;
        this.supervisor = supervisor;
    }
    public Event(Long id, String name, Location location, LocalDate dateTime, String subject, Set<Supervisor> supervisor) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.dateTime = dateTime;
        this.subject = subject;
        this.supervisor = supervisor;
    }
}
