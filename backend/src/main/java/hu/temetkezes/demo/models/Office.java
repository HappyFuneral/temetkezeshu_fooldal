package hu.temetkezes.demo.models;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Office extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String shortCode;

    private String location;
    private double latitude;
    private double longitude;
    private String country;
    private String postal;
    private String region;
    private String city;
    private String address;
    private String code;
    private String website;

    @OneToMany
    @JsonManagedReference
    private List<Contact> contacts;

    @ManyToOne
    @JsonManagedReference
    private Company company;

    public Office(String name, String shortCode, String location, double latitude, double longitude, String country, String postal, String region, String city, String address, String code, Company company, String website, List<Contact> contacts) {
        this.name = name;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.postal = postal;
        this.region = region;
        this.city = city;
        this.address = address;
        this.code = code;
        this.company = company;
        setShortCode(shortCode);
        setWebsite(website);
        setContacts(contacts);

    }
}

