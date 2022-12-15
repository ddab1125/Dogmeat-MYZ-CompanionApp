package pl.coderslab.dogmeat.validator;

import lombok.Data;
import pl.coderslab.dogmeat.user.Dto.UserDto;
import pl.coderslab.dogmeat.user.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Data
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, UserDto> {

    private final UserService userService;
    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext constraintValidatorContext) {
        if (userService.findByEmail(userDto.getEmail()) != null) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{uniqueEmailValidator.error.message}")
                    .addPropertyNode("email").addConstraintViolation();
            return false;
        }
        return true;
    }
}
