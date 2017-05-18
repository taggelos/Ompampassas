package gr.uoa.di.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by e-lias on 17-May-17.
 */
public class TicketEntityPK implements Serializable {
    private String parentUsername;
    private int eventsId;
    private int eventsPlaceId;

    @Column(name = "parent_Username", nullable = false, length = 64)
    @Id
    public String getParentUsername() {
        return parentUsername;
    }

    public void setParentUsername(String parentUsername) {
        this.parentUsername = parentUsername;
    }

    @Column(name = "events_Id", nullable = false)
    @Id
    public int getEventsId() {
        return eventsId;
    }

    public void setEventsId(int eventsId) {
        this.eventsId = eventsId;
    }

    @Column(name = "events_PlaceId", nullable = false)
    @Id
    public int getEventsPlaceId() {
        return eventsPlaceId;
    }

    public void setEventsPlaceId(int eventsPlaceId) {
        this.eventsPlaceId = eventsPlaceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketEntityPK that = (TicketEntityPK) o;

        if (eventsId != that.eventsId) return false;
        if (eventsPlaceId != that.eventsPlaceId) return false;
        if (parentUsername != null ? !parentUsername.equals(that.parentUsername) : that.parentUsername != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = parentUsername != null ? parentUsername.hashCode() : 0;
        result = 31 * result + eventsId;
        result = 31 * result + eventsPlaceId;
        return result;
    }
}
