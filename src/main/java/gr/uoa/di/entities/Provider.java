package gr.uoa.di.entities;

import javax.persistence.*;

@Entity
@Table(name = "providers", schema = "ompampassas", catalog = "")
public class Provider {
    private int mUserId;
    private int userId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Provider that = (Provider) o;

        if (mUserId != that.mUserId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return mUserId;
    }
}
