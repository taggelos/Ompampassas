package gr.uoa.di.entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;

@Entity
@Table(name = "places", schema = "ompampassas", catalog = "")
public class PlacesEntity {
    private int mId;
    private String mTitle;
    private String mAddress;
    private Time mOpeningTime;
    private Time mClosingTime;

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
    @Column(name = "title")
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    @Basic
    @Column(name = "opening_time")
    public Time getOpeningTime() {
        return mOpeningTime;
    }

    public void setOpeningTime(Time openingTime) {
        mOpeningTime = openingTime;
    }

    @Basic
    @Column(name = "closing_time")
    public Time getClosingTime() {
        return mClosingTime;
    }

    public void setClosingTime(Time closingTime) {
        mClosingTime = closingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlacesEntity that = (PlacesEntity) o;

        if (mId != that.mId) return false;
        if (mTitle != null ? !mTitle.equals(that.mTitle) : that.mTitle != null) return false;
        if (mAddress != null ? !mAddress.equals(that.mAddress) : that.mAddress != null) return false;
        if (mOpeningTime != null ? !mOpeningTime.equals(that.mOpeningTime) : that.mOpeningTime != null) return false;
        if (mClosingTime != null ? !mClosingTime.equals(that.mClosingTime) : that.mClosingTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mId;
        result = 31 * result + (mTitle != null ? mTitle.hashCode() : 0);
        result = 31 * result + (mAddress != null ? mAddress.hashCode() : 0);
        result = 31 * result + (mOpeningTime != null ? mOpeningTime.hashCode() : 0);
        result = 31 * result + (mClosingTime != null ? mClosingTime.hashCode() : 0);
        return result;
    }
}
