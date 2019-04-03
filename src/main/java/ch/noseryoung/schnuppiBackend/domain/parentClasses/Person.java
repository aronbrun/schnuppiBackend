package ch.noseryoung.schnuppiBackend.domain.parentClasses;

import javax.persistence.*;

@Entity
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

    public Person(Long id, String name, String surName, String email) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.email = email;
    }

    public Person(String name, String surName, String email) {
        this.name = name;
        this.surName = surName;
        this.email = email;
    }
}
