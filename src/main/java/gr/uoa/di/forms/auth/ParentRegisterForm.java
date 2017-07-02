package gr.uoa.di.forms.auth;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class ParentRegisterForm extends UserRegisterForm {

    @NotEmpty(message = "Το Όνομα είναι υποχρεωτικό.")
    @Size(max = 255, message = "Το Όνομα δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String name;

    @NotEmpty(message = "Το Επώνυμο είναι υποχρεωτικό.")
    @Size(max = 255, message = "Το Επώνυμο δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String surname;

    @NotEmpty(message = "Το Τηλέφωνο Επικοινωνίας είναι υποχρεωτικό.")
    @Size(max = 255, message = "Το Τηλέφωνο Επικοινωνίας δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String mPhone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

}