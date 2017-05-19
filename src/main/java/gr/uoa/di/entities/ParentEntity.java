package gr.uoa.di.entities;

import javax.persistence.*;

/**
 * Created by karat on 5/19/2017.
 */
@Entity
@Table(name = "parent", schema = "ompampassas", catalog = "")
public class ParentEntity {
    private int userId;
    private int credits;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "credits")
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParentEntity that = (ParentEntity) o;

        if (userId != that.userId) return false;
        if (credits != that.credits) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + credits;
        return result;
    }
}
