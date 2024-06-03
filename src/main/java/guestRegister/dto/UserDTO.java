package guestRegister.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

    @JsonProperty("_id")
    private long userId;

    @Email
    private String email;

    @NotBlank(message = "FiLl up the user password")
    @Size(min = 6, message = "Password has to have at least six characters")
    private String password;

    @JsonProperty("isAdmin")
    private boolean admin;

}
