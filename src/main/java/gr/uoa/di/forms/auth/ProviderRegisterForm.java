package gr.uoa.di.forms.auth;

import gr.uoa.di.utils.constraints.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@PasswordsMatchConstraint(message = "Ο Κωδικός Πρόσβασης και η Επιβεβαίωση Κωδικού Πρόσβασης πρέπει να ταυτίζονται.")
@EmailUniqueConstraint(message = "Το Email που εισάγατε χρησιμοποιείται ήδη. Παρακαλούμε επιλέξτε κάποιο άλλο.")
@TaxOfficeExistsConstraint(message = "Επιλέξτε μία ΔΟΥ από τη λίστα.")
@VatNumberUniqueConstraint(message = "Το ΑΦΜ που εισάγατε υπάρχει ήδη.")
@CompanyNameUniqueConstraint(message = "Η Επωνυμία Εταιρείας που εισάγατε υπάρχει ήδη.")

public class ProviderRegisterForm {
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

    @NotEmpty(message = "Το Εμφανιζόμενο Όνομα είναι υποχρεωτικό.")
    @Size(max = 255, message = "Το Εμφανιζόμενο Όνομα δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String title;

    @NotEmpty(message = "Η Επωνυμία Εταιρείας είναι υποχρεωτική.")
    @Size(max = 255, message = "Η Επωνυμία Εταιρείας δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String companyName;

    @NotEmpty(message = "Το ΑΦΜ είναι υποχρεωτικό.")
    @Size(max = 20, message = "Το ΑΦΜ δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String vatNumber;

    private int taxOfficeId;

    @NotEmpty(message = "Το Τηλέφωνο είναι υποχρεωτικό.")
    @Size(max = 255, message = "Το Τηλέφωνο δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String phone;

    @Size(max = 255, message = "Το Fax δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String fax;

    @NotEmpty(message = "Η Διεύθυνση είναι υποχρεωτική.")
    @Size(max = 255, message = "Η Διεύθυνση δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String address;

    @NotEmpty(message = "Ο Ταχυδρομικός Κώδικας είναι υποχρεωτικός.")
    @Size(max = 20, message = "Ο Ταχυδρομικός Κώδικας δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String zipCode;

    @NotEmpty(message = "Η Περιοχή είναι υποχρεωτική.")
    @Size(max = 255, message = "Η Περιοχή δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String region;

    @NotEmpty(message = "Η Πόλη είναι υποχρεωτική.")
    @Size(max = 255, message = "Η Πόλη δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String city;

    private String latitude;
    private String longitude;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public int getTaxOfficeId() {
        return taxOfficeId;
    }

    public void setTaxOfficeId(int taxOfficeId) {
        this.taxOfficeId = taxOfficeId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}