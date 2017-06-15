package gr.uoa.di.entities;

import javax.persistence.*;

@Entity
@Table(name = "tickets", schema = "ompampassas", catalog = "")
public class Ticket {
    private int mId;
    private int mParentId;
    private int mEventId;
    private int mPrice;
    private int id;
    private int parentId;
    private int eventId;
    private int price;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    @Basic
    @Column(name = "parent_id")
    public int getParentId() {
        return mParentId;
    }

    public void setParentId(int parentId) {
        mParentId = parentId;
    }

    @Basic
    @Column(name = "event_id")
    public int getEventId() {
        return mEventId;
    }

    public void setEventId(int eventId) {
        mEventId = eventId;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return mPrice;
    }

    public void setPrice(int price) {
        mPrice = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket that = (Ticket) o;

        if (mId != that.mId) return false;
        if (mParentId != that.mParentId) return false;
        if (mEventId != that.mEventId) return false;
        if (mPrice != that.mPrice) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mId;
        result = 31 * result + mParentId;
        result = 31 * result + mEventId;
        result = 31 * result + mPrice;
        return result;
    }
}
