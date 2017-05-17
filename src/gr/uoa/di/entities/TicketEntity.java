package gr.uoa.di.entities;

import javax.persistence.*;

/**
 * Created by e-lias on 17-May-17.
 */
@Entity
@Table(name = "ticket", schema = "ompampassas", catalog = "")
@IdClass(TicketEntityPK.class)
public class TicketEntity {
    private String parentUsername;
    private int eventsId;
    private int eventsPlaceId;

    @Id
    @Column(name = "parent_Username", nullable = false, length = 64)
    public String getParentUsername() {
        return parentUsername;
    }

    public void setParentUsername(String parentUsername) {
        this.parentUsername = parentUsername;
    }

    @Id
    @Column(name = "events_Id", nullable = false)
    public int getEventsId() {
        return eventsId;
    }

    public void setEventsId(int eventsId) {
        this.eventsId = eventsId;
    }

    @Id
    @Column(name = "events_PlaceId", nullable = false)
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

        TicketEntity that = (TicketEntity) o;

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
