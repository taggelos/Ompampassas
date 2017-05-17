package gr.uoa.di.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by e-lias on 17-May-17.
 */
public class EventsEntityPK implements Serializable {
    private int id;
    private int placeId;

    @Column(name = "Id", nullable = false)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "PlaceId", nullable = false)
    @Id
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventsEntityPK that = (EventsEntityPK) o;

        if (id != that.id) return false;
        if (placeId != that.placeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + placeId;
        return result;
    }
}
