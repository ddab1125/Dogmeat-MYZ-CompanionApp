package pl.coderslab.dogmeat.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = UniqueEmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {

    String message() default "{uniqueEmailValidator.error.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
