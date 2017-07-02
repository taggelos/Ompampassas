package gr.uoa.di.entities;

import javax.persistence.*;

@Entity
public class User {
    private int id;
    private String email;
    private String password;
    private String role;
    private boolean enabled;
    private ParentMetadata parentMetadataById;
    private ProviderMetadata providerMetadataById;

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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (enabled != user.enabled) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return role != null ? role.equals(user.role) : user.role == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }

    @OneToOne(mappedBy = "userByUserId")
    public ParentMetadata getParentMetadataById() {
        return parentMetadataById;
    }

    public void setParentMetadataById(ParentMetadata parentMetadataById) {
        this.parentMetadataById = parentMetadataById;
    }

    @OneToOne(mappedBy = "userByUserId")
    public ProviderMetadata getProviderMetadataById() {
        return providerMetadataById;
    }

    public void setProviderMetadataById(ProviderMetadata providerMetadataById) {
        this.providerMetadataById = providerMetadataById;
    }
}
