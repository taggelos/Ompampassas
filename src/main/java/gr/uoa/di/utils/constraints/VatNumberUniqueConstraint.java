package gr.uoa.di.utils.constraints;

import gr.uoa.di.utils.constraints.impl.VatNumberUniqueConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = VatNumberUniqueConstraintValidator.class)
public @interface VatNumberUniqueConstraint {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}