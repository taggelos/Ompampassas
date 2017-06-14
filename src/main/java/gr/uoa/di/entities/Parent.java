package gr.uoa.di.entities;

import javax.persistence.*;

@Entity
@Table(name = "parents", schema = "ompampassas", catalog = "")
public class Parent {
    private int mUserId;
    private int mCredits;
    private int userId;
    private int credits;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    @Basic
    @Column(name = "credits")
    public int getCredits() {
        return mCredits;
    }

    public void setCredits(int credits) {
        mCredits = credits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parent that = (Parent) o;

        if (mUserId != that.mUserId) return false;
        if (mCredits != that.mCredits) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mUserId;
        result = 31 * result + mCredits;
        return result;
    }
}
