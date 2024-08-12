package hu.temetkezes.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Role extends BaseEntity{
    private String name;
    private String authorities;


   public Role(String name, String authorities){
       setName(name);
       setAuthorities(authorities);
   }
}