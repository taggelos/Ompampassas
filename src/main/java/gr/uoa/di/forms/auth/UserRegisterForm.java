package gr.uoa.di.forms.auth;

import gr.uoa.di.utils.constraints.EmailUniqueConstraint;
import gr.uoa.di.utils.constraints.PasswordsMatchConstraint;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@PasswordsMatchConstraint(message = "Ο Κωδικός Πρόσβασης και η Επιβεβαίωση Κωδικού Πρόσβασης πρέπει να ταυτίζονται.")
@EmailUniqueConstraint(message = "Το Email που εισάγατε χρησιμοποιείται ήδη. Παρακαλούμε επιλέξτε κάποιο άλλο.")

public class UserRegisterForm {
    @NotEmpty(message = "Το Email είναι υποχρεωτικό.")
    @Email(message = "Το Email που εισάγατε δεν είναι έγκυρο.")
    @Size(max = 255, message = "Το Email δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String email;

    @NotEmpty(message = "O Κωδικός Πρόσβασης είναι υποχρεωτικός.")
    @Size(min = 6, max = 30, message = "Ο Κωδικός Πρόσβασης θα πρέπει να αποτελείται από 6 μέχρι 30 χαρακτήρες.")
    private String password;

    @NotEmpty(message = "Η Επιβεβαίωση Κωδικού Πρόσβασης είναι υποχρεωτική.")
    @Size(min = 6, max = 30, message = "Η Επιβεβαίωση Κωδικού Πρόσβασης θα πρέπει να αποτελείται από 6 μέχρι 30 χαρακτήρες.")
    private String passwordConfirmation;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

}
