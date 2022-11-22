package pl.coderslab.dogmeat.validator;

import pl.coderslab.dogmeat.user.Dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserDto> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserDto user, ConstraintValidatorContext context) {

        if (!user.getPassword().equals(user.getPassword2())) {
            context.buildConstraintViolationWithTemplate("{passwordMatches.error.message}")
                    .addPropertyNode("password2").addConstraintViolation();
            return false;
        }
        return true;
    }


}
