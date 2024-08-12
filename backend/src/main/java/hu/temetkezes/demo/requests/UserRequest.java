package hu.temetkezes.demo.requests;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {


    @NotEmpty(message =  "Username is empty")
    private String username;
    @NotEmpty(message = "Password is empty")
    private String password;
    @NotEmpty(message = "Email is empty")
    @Email(message = "Invaild email address")
    private String email;
}
