package hu.temetkezes.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Company extends BaseEntity {

    private String name;
    private String shortName;

    public Company(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }


}
