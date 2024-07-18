package hu.temetkezes.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

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

    @OneToMany
    @JsonManagedReference
    private List<FuneralOptions> options;

    public FuneralService(String name, String shortName, String description) {
        this.name = name;
        this.shortName = shortName;
        this.description = description;
    }
}
