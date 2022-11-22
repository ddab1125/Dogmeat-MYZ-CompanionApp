package pl.coderslab.dogmeat.user.Dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import pl.coderslab.dogmeat.validator.PasswordMatches;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@PasswordMatches
public class UserDto {

    @NotNull
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    @Email
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    private String password2;
}
