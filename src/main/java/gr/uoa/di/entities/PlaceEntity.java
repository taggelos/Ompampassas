package gr.uoa.di.entities;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by karat on 5/19/2017.
 */
@Entity
@Table(name = "place", schema = "ompampassas", catalog = "")
public class PlaceEntity {
    private int id;
    private String title;
    private String address;
    private Time openingTime;
    private Time closingTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "opening_time")
    public Time getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Time openingTime) {
        this.openingTime = openingTime;
    }

    @Basic
    @Column(name = "closing_time")
    public Time getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Time closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaceEntity that = (PlaceEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (openingTime != null ? !openingTime.equals(that.openingTime) : that.openingTime != null) return false;
        if (closingTime != null ? !closingTime.equals(that.closingTime) : that.closingTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (openingTime != null ? openingTime.hashCode() : 0);
        result = 31 * result + (closingTime != null ? closingTime.hashCode() : 0);
        return result;
    }
}
