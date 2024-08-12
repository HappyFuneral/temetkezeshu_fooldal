package hu.temetkezes.demo.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class LoginRequest
{
    @NotEmpty(message =  "Email is empty")
    private String email;
    @NotEmpty(message = "Password is empty")
    private String password;
}
