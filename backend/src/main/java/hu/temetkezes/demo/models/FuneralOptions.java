package hu.temetkezes.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class FuneralOptions extends  BaseEntity{


    private String name;
    private String description;
    private int price;

    public FuneralOptions(String name, String description, int price){
        setName(name);
        setDescription(description);
        setPrice(price);
    }
}
