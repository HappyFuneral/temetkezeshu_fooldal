package hu.temetkezes.demo.models;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
}