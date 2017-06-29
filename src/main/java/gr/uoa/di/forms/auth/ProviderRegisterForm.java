package gr.uoa.di.forms.auth;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class ProviderRegisterForm extends RegisterForm {
    @NotEmpty(message = "Το Εμφανιζόμενο Όνομα είναι υποχρεωτικό.")
    @Size(max = 255, message = "Το Εμφανιζόμενο Όνομα δεν πρέπει να υπερβαίνει τους {max} χαρακτήρες.")
    private String mTitle;

    private String mCompanyName;
    private String mVatNumber;
    private int mTaxOfficeId;
    private String mFullName;
    private String mJobPosition;
    private String mPhone;
    private String mFax;
    private String mAddress;
    private String mZipCode;
    private String mRegion;
    private String mCity;
    private String mLatitude;
    private String mLongitude;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getCompanyName() {
        return mCompanyName;
    }

    public void setCompanyName(String companyName) {
        mCompanyName = companyName;
    }

    public String getVatNumber() {
        return mVatNumber;
    }

    public void setVatNumber(String vatNumber) {
        mVatNumber = vatNumber;
    }

    public int getTaxOfficeId() {
        return mTaxOfficeId;
    }

    public void setTaxOfficeId(int taxOfficeId) {
        mTaxOfficeId = taxOfficeId;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getJobPosition() {
        return mJobPosition;
    }

    public void setJobPosition(String jobPosition) {
        mJobPosition = jobPosition;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getFax() {
        return mFax;
    }

    public void setFax(String fax) {
        mFax = fax;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getZipCode() {
        return mZipCode;
    }

    public void setZipCode(String zipCode) {
        mZipCode = zipCode;
    }

    public String getRegion() {
        return mRegion;
    }

    public void setRegion(String region) {
        mRegion = region;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String latitude) {
        mLatitude = latitude;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public void setLongitude(String longitude) {
        mLongitude = longitude;
    }
}