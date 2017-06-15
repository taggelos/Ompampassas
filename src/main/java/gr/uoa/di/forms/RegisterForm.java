package gr.uoa.di.forms;

import gr.uoa.di.utils.constraints.EmailUniqueConstraint;
import gr.uoa.di.utils.constraints.PasswordsMatchConstraint;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@PasswordsMatchConstraint(message = "Ο Κωδικός Πρόσβασης και η Επιβεβαίωση Κωδικού Πρόσβασης πρέπει να ταυτίζονται.")
@EmailUniqueConstraint(message = "Το Email που εισάγατε χρησιμοποιείται ήδη. Παρακαλούμε επιλέξτε κάποιο άλλο.")

public class RegisterForm {
    @NotEmpty(message = "Το Email είναι υποχρεωτικό.")
    @Email(message = "Το Email που εισάγατε δεν είναι έγκυρο.")
    @Size(max = 255, message = "Το Email δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String mEmail;

    @NotEmpty(message = "O Κωδικός Πρόσβασης είναι υποχρεωτικός.")
    @Size(min = 6, max = 30, message = "Ο Κωδικός Πρόσβασης θα πρέπει να αποτελείται από 6 μέχρι 30 χαρακτήρες.")
    private String mPassword;

    @NotEmpty(message = "Η Επιβεβαίωση Κωδικού Πρόσβασης είναι υποχρεωτική.")
    @Size(min = 6, max = 30, message = "Η Επιβεβαίωση Κωδικού Πρόσβασης θα πρέπει να αποτελείται από 6 μέχρι 30 χαρακτήρες.")
    private String mPasswordConfirmation;

    @NotEmpty(message = "Το Όνομα είναι υποχρεωτικό.")
    @Size(max = 255, message = "Το Όνομα δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String mName;

    @NotEmpty(message = "Το Επώνυμο είναι υποχρεωτικό.")
    @Size(max = 255, message = "Το Επώνυμο δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String mSurname;

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getPasswordConfirmation() {
        return mPasswordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        mPasswordConfirmation = passwordConfirmation;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSurname() {
        return mSurname;
    }

    public void setSurname(String surname) {
        mSurname = surname;
    }
}