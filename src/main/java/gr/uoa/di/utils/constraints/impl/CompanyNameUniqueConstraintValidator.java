package gr.uoa.di.utils.constraints.impl;

import gr.uoa.di.forms.auth.ProviderRegisterForm;
import gr.uoa.di.repositories.ProviderMetadataRepository;
import gr.uoa.di.utils.constraints.CompanyNameUniqueConstraint;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CompanyNameUniqueConstraintValidator implements ConstraintValidator<CompanyNameUniqueConstraint, ProviderRegisterForm> {
    @Autowired
    private ProviderMetadataRepository repo;

    /**
     * Initializes the validator in preparation for
     * {@link #isValid(Object, ConstraintValidatorContext)} calls.
     * The constraint annotation for a given constraint declaration
     * is passed.
     * <p/>
     * This method is guaranteed to be called before any use of this instance for
     * validation.
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(CompanyNameUniqueConstraint constraintAnnotation) {

    }

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p/>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param form    object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(ProviderRegisterForm form, ConstraintValidatorContext context) {
        String companyName = form.getCompanyName();

        return !repo.existsByCompanyName(companyName);
    }
}