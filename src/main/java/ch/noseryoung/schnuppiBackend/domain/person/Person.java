package ch.noseryoung.schnuppiBackend.domain.person;

import javax.persistence.*;
import javax.websocket.ClientEndpoint;

@Entity
@Table
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String surName;

    @Column


}
