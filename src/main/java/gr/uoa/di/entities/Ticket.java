package gr.uoa.di.entities;

import javax.persistence.*;

/**
 * Created by e-lias on 17-Jun-17.
 */
@Entity
@Table(name = "tickets", schema = "ompampassas", catalog = "")
public class Ticket {
    private int id;
    private int parentId;
    private int eventId;
    private int price;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parent_id", nullable = false)
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "event_id", nullable = false)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
