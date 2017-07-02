package gr.uoa.di.utils.constraints;

import gr.uoa.di.utils.constraints.impl.TaxOfficeExistsConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = TaxOfficeExistsConstraintValidator.class)
public @interface TaxOfficeExistsConstraint {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}