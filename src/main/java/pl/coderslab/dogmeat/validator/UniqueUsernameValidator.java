package pl.coderslab.dogmeat.validator;

import lombok.Data;
import pl.coderslab.dogmeat.user.Dto.UserDto;
import pl.coderslab.dogmeat.user.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Data
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, UserDto> {

    private final UserService userService;
    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext constraintValidatorContext) {
        if (userService.findByUsername(userDto.getUsername()) != null) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{uniqueUsername.error.message}")
                    .addPropertyNode("username").addConstraintViolation();
            return false;
        }
        return true;
    }
}
