package ch.noseryoung.schnuppiBackend.domain.parentClasses;

import javax.persistence.*;

@Entity
@MappedSuperclass
public class Person {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String surName;

    @Column
    private String email;
}
