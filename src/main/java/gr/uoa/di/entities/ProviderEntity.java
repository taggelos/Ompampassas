package gr.uoa.di.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by karat on 5/19/2017.
 */
@Entity
@Table(name = "provider", schema = "ompampassas", catalog = "")
public class ProviderEntity {
    private int userId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProviderEntity that = (ProviderEntity) o;

        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userId;
    }
}
