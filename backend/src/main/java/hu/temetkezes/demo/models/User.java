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

    private String name;
    private String username;
    private String password;
    private String role;
    private String email;
    private boolean active;
    private boolean banned;
    private boolean confirmEmail;
}