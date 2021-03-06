package gr.uoa.di.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tax_office", schema = "ompampassas")
public class TaxOffice {
    private int id;
    private String name;
    private Collection<ProviderMetadata> providerMetadataById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxOffice taxOffice = (TaxOffice) o;

        if (id != taxOffice.id) return false;
        return name != null ? name.equals(taxOffice.name) : taxOffice.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "taxOfficeByTaxOfficeId")
    public Collection<ProviderMetadata> getProviderMetadataById() {
        return providerMetadataById;
    }

    public void setProviderMetadataById(Collection<ProviderMetadata> providerMetadataById) {
        this.providerMetadataById = providerMetadataById;
    }
}
