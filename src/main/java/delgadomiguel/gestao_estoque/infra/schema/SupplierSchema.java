package delgadomiguel.gestao_estoque.infra.schema;

import jakarta.persistence.*;
import lombok.*;

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

    private String cnpj;

    private String address;
    private String phone;
    private String email;

    @Column(name = "main_contact")
    private String mainContact;

    @ManyToMany(mappedBy = "suppliers") // "suppliers" é o nome do campo na classe ProductSchema
    private Set<ProductSchema> products = new HashSet<>();
}