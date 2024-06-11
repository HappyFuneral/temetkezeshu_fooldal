package hu.temetkezes.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FuneralService {


    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String shortName;
    private String description;


    public FuneralService(String name, String shortName, String description) {
        this.name = name;
        this.shortName = shortName;
        this.description = description;
    }
}
