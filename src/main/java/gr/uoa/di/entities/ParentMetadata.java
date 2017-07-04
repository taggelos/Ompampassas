package gr.uoa.di.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "parent_metadata", schema = "ompampassas")
public class ParentMetadata {
    private int userId;
    private String firstName;
    private String lastName;
    private String phone;
    private int points;
    private User userByUserId;
    private Collection<Ticket> ticketsByUserId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "points")
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParentMetadata metadata = (ParentMetadata) o;

        if (userId != metadata.userId) return false;
        if (points != metadata.points) return false;
        if (firstName != null ? !firstName.equals(metadata.firstName) : metadata.firstName != null) return false;
        if (lastName != null ? !lastName.equals(metadata.lastName) : metadata.lastName != null) return false;
        return phone != null ? phone.equals(metadata.phone) : metadata.phone == null;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + points;
        return result;
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "parentMetadataByParentId")
    public Collection<Ticket> getTicketsByUserId() {
        return ticketsByUserId;
    }

    public void setTicketsByUserId(Collection<Ticket> ticketsByUserId) {
        this.ticketsByUserId = ticketsByUserId;
    }
}
