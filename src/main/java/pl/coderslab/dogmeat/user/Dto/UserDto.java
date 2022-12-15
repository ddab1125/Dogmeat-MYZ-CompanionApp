package pl.coderslab.dogmeat.user.Dto;

import lombok.Data;
import pl.coderslab.dogmeat.validator.PasswordMatches;
import pl.coderslab.dogmeat.validator.UniqueEmail;
import pl.coderslab.dogmeat.validator.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@PasswordMatches
@UniqueUsername
@UniqueEmail
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
