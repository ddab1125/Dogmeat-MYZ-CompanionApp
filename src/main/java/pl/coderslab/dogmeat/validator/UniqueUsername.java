package pl.coderslab.dogmeat.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = UniqueUsernameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {

    String message() default "{uniqueUsername.error.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
