package ch.noseryoung.schnuppiBackend.domain.location;

import javax.persistence.*;

@Entity
@Table
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String locationName;

    @Column
    private String adress;
    
    @Column
    private String city;

    @Column
    private String postalCode;

    @Column
    private String country;
}
