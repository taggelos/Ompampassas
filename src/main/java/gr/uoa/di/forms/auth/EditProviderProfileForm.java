package gr.uoa.di.forms.auth;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class EditProviderProfileForm {
    @NotEmpty(message = "Το Εμφανιζόμενο Όνομα είναι υποχρεωτικό.")
    @Size(max = 255, message = "Το Εμφανιζόμενο Όνομα δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String title;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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