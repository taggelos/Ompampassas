package gr.uoa.di.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Comment {
    private int id;
    private String message;
    private Timestamp timestamp;
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
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "timestamp")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (message != null ? !message.equals(comment.message) : comment.message != null) return false;
        return timestamp != null ? timestamp.equals(comment.timestamp) : comment.timestamp == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
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
