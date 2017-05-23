package gr.uoa.di.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users", schema = "ompampassas", catalog = "")
public class UsersEntity {
    private int mId;
    private String mEmail;
    private String mPassword;
    private String mName;
    private String mSurname;
    private int id;
    private Serializable role;
    private String email;
    private String password;
    private String name;
    private String surname;
    private int age;

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
    @Column(name = "role")
    public Serializable getRole() {
        return role;
    }

    public void setRole(Serializable role) {
        this.role = role;
    }

    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (mId != that.mId) return false;
        if (age != that.age) return false;
        if (mEmail != null ? !mEmail.equals(that.mEmail) : that.mEmail != null) return false;
        if (mPassword != null ? !mPassword.equals(that.mPassword) : that.mPassword != null) return false;
        if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;
        if (mSurname != null ? !mSurname.equals(that.mSurname) : that.mSurname != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (mEmail != null ? mEmail.hashCode() : 0);
        result = 31 * result + (mPassword != null ? mPassword.hashCode() : 0);
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (mSurname != null ? mSurname.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}