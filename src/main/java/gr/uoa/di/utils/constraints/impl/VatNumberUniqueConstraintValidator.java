package gr.uoa.di.utils.constraints.impl;

import gr.uoa.di.entities.ProviderMetadata;
import gr.uoa.di.forms.auth.ProviderRegisterForm;
import gr.uoa.di.utils.DatabaseUtils;
import gr.uoa.di.utils.constraints.VatNumberUniqueConstraint;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class VatNumberUniqueConstraintValidator implements ConstraintValidator<VatNumberUniqueConstraint, Object> {
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
    public void initialize(VatNumberUniqueConstraint constraintAnnotation) {

    }

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p/>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        ProviderRegisterForm form = (ProviderRegisterForm) value;
        String vatNumber = form.getVatNumber();

        Session session = DatabaseUtils.getSession();
        Query query = session.createQuery("from ProviderMetadata metadata where metadata.vatNumber = :vat");
        query.setString("vat", vatNumber);
        List<ProviderMetadata> users = (List<ProviderMetadata>) query.list();

        return users.isEmpty();
    }
}