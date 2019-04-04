package ch.noseryoung.schnuppiBackend.domain.location;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String locationName;

    @Column
    private String address;
    
    @Column
    private String city;

    @Column
    private String postalCode;

    @Column
    private String country;

    public Location() {
    }

    public Location(Long id, String locationName, String adress, String city, String postalCode, String country) {
        this.id = id;
        this.locationName = locationName;
        this.address = adress;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Location(String locationName, String adress, String city, String postalCode, String country) {
        this.locationName = locationName;
        this.address = adress;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }
}
