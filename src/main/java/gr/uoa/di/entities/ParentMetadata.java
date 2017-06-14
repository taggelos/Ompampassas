package gr.uoa.di.entities;

import javax.persistence.*;

@Entity
@Table(name = "parent_metadata", schema = "ompampassas", catalog = "")
public class ParentMetadata {
    private int mId;
    private int mUserId;
    private String mFirstName;
    private String mLastName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    @Column(name = "user_id")
    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }
}