package hu.temetkezes.demo.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity{

    private String username;
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    private List<Role> roles;
    private boolean active;

}