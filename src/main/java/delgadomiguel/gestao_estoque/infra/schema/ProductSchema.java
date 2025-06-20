package delgadomiguel.gestao_estoque.infra.schema;

import delgadomiguel.gestao_estoque.application.implementation.utils.ProductCategoryParser;
import delgadomiguel.gestao_estoque.domain.model.Product;
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

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

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

    // Usar somente na Criacao
    public static ProductSchema fromDomain(Product product) {
        ProductSchema schema = new ProductSchema();
        schema.setName(product.getName());
        schema.setBarCode(product.getBarCode());
        schema.setDescription(product.getDescription());
        schema.setStockQuantity(product.getStockQuantity());
        schema.setCategory(String.valueOf(product.getCategory().getLabel()));
        schema.setIsActive(Boolean.TRUE); // produto nasce ativo
        schema.setProductValidity(product.getProductValidity().getValue());
        schema.setImgUrl(product.getImgUrl());
        schema.setSuppliers(new HashSet<>()); // vazio inicialmente
        return schema;
    }

    public Product toDomain() {
        return new Product(
                this.name,
                this.barCode,
                ProductCategoryParser.executeParseCategory(this.category),
                this.description,
                this.imgUrl,
                this.productValidity,
                this.stockQuantity
        );
    }

    public void updateFromDomain(Product product) {
        this.name = product.getName();
        this.barCode = product.getBarCode();
        this.description = product.getDescription();
        this.category = product.getCategory().getLabel();
        this.productValidity = product.getProductValidity().getValue();
        this.imgUrl = product.getImgUrl();
        this.stockQuantity = product.getStockQuantity();
    }

}