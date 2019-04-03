package ch.noseryoung.schnuppiBackend.domain.parentClasses;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@MappedSuperclass
@Getter @Setter
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
