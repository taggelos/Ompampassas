package gr.uoa.di.entities;

import javax.persistence.*;

@Entity
@Table(name = "provider_metadata", schema = "ompampassas", catalog = "")
public class ProviderMetadata {
    private int mId;
    private int mUserId;
    private String mTitle;
    private String mCompanyName;
    private String mFullName;
    private String mJobPosition;

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

    @Column(name = "title")
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    @Column(name = "company_name")
    public String getCompanyName() {
        return mCompanyName;
    }

    public void setCompanyName(String companyName) {
        mCompanyName = companyName;
    }

    @Column(name = "full_name")
    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    @Column(name = "job_position")
    public String getJobPosition() {
        return mJobPosition;
    }

    public void setJobPosition(String jobPosition) {
        mJobPosition = jobPosition;
    }
}