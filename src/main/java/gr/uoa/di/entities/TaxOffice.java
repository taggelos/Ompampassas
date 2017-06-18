package gr.uoa.di.entities;

import javax.persistence.*;

/**
 * Created by e-lias on 17-Jun-17.
 */
@Entity
@Table(name = "tax_offices", schema = "ompampassas", catalog = "")
public class TaxOffice {
    private int id;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
