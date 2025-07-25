package delgadomiguel.gestao_estoque.infra.schema;

import delgadomiguel.gestao_estoque.domain.model.Supplier;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "suppliers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class SupplierSchema {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "company_name")
    private String companyName;

    @Column(unique = true)
    private String cnpj;

    private String address;
    private String phone;
    private String email;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "main_contact")
    private String mainContact;

    @ManyToMany(mappedBy = "suppliers") // "suppliers" é o nome do campo na classe ProductSchema
    private Set<ProductSchema> products = new HashSet<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    public static SupplierSchema fromDomain(Supplier supplier) {
        SupplierSchema schema = new SupplierSchema();
        schema.setCompanyName(supplier.getCompanyName());
        schema.setCnpj(supplier.getCnpj());
        schema.setAddress(supplier.getAddress());
        schema.setPhone(supplier.getPhone());
        schema.setEmail(supplier.getEmail());
        schema.setMainContact(supplier.getMainContact());
        schema.setIsActive(true);

        return schema;
    }

    public Supplier toDomain() {
        return new Supplier(
                this.address,
                this.cnpj,
                this.companyName,
                this.email,
                this.mainContact,
                this.phone
        );
    }
}