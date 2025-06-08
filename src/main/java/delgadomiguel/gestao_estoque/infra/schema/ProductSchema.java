package delgadomiguel.gestao_estoque.infra.schema;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductSchema {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Column(name = "bar_code", unique = true)
    private String barCode;

    private String description;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    private String category;

    @Column(name = "product_validity")
    private Date productValidity;

    @Column(name = "img_url")
    private String imgUrl;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "product_suppliers", // Nome da tabela de junção
            joinColumns = @JoinColumn(name = "product_id"), // Chave estrangeira para ProductSchema
            inverseJoinColumns = @JoinColumn(name = "supplier_id") // Chave estrangeira para SupplierSchema
    )
    private Set<SupplierSchema> suppliers = new HashSet<>();
}