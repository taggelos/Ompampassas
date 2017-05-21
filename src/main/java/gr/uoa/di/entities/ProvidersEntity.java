package gr.uoa.di.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "providers", schema = "ompampassas", catalog = "")
public class ProvidersEntity {
    private int mUserId;

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

        ProvidersEntity that = (ProvidersEntity) o;

        if (mUserId != that.mUserId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return mUserId;
    }
}
