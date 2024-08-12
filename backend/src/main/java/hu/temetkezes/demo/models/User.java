package hu.temetkezes.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity{

    private String userId;
    private String name;
    @NotEmpty(message =  "Username is empty")
    private String username;
    @NotEmpty(message = "Password is empty")
    private String password;
    @ManyToOne
    private Role role;
    private String email;
    private boolean active;
    private boolean banned;
    private boolean confirmEmail;
    private Integer loginAttempt;
    private String phone;
    private String bio;
    private String imageUrl;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean mfa;
    private LocalDateTime lastLogin;
    @JsonIgnore
    private String qrCodeSecret;
    private String qrCodeImageUri;



}