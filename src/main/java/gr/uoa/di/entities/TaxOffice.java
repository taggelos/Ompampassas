package gr.uoa.di.entities;

import javax.persistence.*;

@Entity
@Table(name = "tax_offices", schema = "ompampassas", catalog = "")
public class TaxOffice {
    private int mId;
    private String mName;

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
    @Column(name = "name")
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}