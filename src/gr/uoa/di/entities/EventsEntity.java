package gr.uoa.di.entities;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by e-lias on 17-May-17.
 */
@Entity
@Table(name = "events", schema = "ompampassas", catalog = "")
@IdClass(EventsEntityPK.class)
public class EventsEntity {
    private int id;
    private int placeId;
    private String ownerId;
    private String name;
    private Time startingTime;
    private Time endingTime;
    private int price;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "PlaceId", nullable = false)
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "OwnerId", nullable = false, length = 64)
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "StartingTime", nullable = false)
    public Time getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Time startingTime) {
        this.startingTime = startingTime;
    }

    @Basic
    @Column(name = "EndingTime", nullable = false)
    public Time getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Time endingTime) {
        this.endingTime = endingTime;
    }

    @Basic
    @Column(name = "Price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventsEntity that = (EventsEntity) o;

        if (id != that.id) return false;
        if (placeId != that.placeId) return false;
        if (price != that.price) return false;
        if (ownerId != null ? !ownerId.equals(that.ownerId) : that.ownerId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (startingTime != null ? !startingTime.equals(that.startingTime) : that.startingTime != null) return false;
        if (endingTime != null ? !endingTime.equals(that.endingTime) : that.endingTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + placeId;
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (startingTime != null ? startingTime.hashCode() : 0);
        result = 31 * result + (endingTime != null ? endingTime.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}
