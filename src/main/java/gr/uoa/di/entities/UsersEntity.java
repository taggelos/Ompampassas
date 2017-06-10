package gr.uoa.di.entities;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "ompampassas", catalog = "")
public class UsersEntity {
    private int mId;
    private String mEmail;
    private String mPassword;
    private String mRole;
    private String mName;
    private String mSurname;
    private int mEnabled;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return mRole;
    }

    public void setRole(String role) {
        this.mRole = role;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return mSurname;
    }

    public void setSurname(String surname) {
        mSurname = surname;
    }

    @Basic
    @Column(name = "enabled")
    public boolean getEnabled() {
        return mEnabled == 1;
    }

    public void setEnabled(boolean enabled) {
        if (enabled)
            mEnabled = 1;
        else
            mEnabled = 0;
    }
}