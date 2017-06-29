package gr.uoa.di.entities;

import javax.persistence.*;

@Entity
public class Ticket {
    private int id;
    private int price;
    private int numOfTickets;
    private ParentMetadata parentMetadataByParentId;
    private Event eventByEventId;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "num_of_tickets")
    public int getNumOfTickets() {
        return numOfTickets;
    }

    public void setNumOfTickets(int numOfTickets) {
        this.numOfTickets = numOfTickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (price != ticket.price) return false;
        return numOfTickets == ticket.numOfTickets;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + price;
        result = 31 * result + numOfTickets;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "user_id", nullable = false)
    public ParentMetadata getParentMetadataByParentId() {
        return parentMetadataByParentId;
    }

    public void setParentMetadataByParentId(ParentMetadata parentMetadataByParentId) {
        this.parentMetadataByParentId = parentMetadataByParentId;
    }

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
    public Event getEventByEventId() {
        return eventByEventId;
    }

    public void setEventByEventId(Event eventByEventId) {
        this.eventByEventId = eventByEventId;
    }
}
