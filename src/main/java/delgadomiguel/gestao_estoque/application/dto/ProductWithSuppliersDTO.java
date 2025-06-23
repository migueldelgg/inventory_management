package delgadomiguel.gestao_estoque.application.dto;

import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;

import java.util.List;
import java.util.UUID;

public class ProductWithSuppliersDTO {
    private UUID id;
    private String name;
    private String barCode;
    private String description;
    private String category;
    private String imgUrl;

    private List<SupplierBasicDTO> suppliers;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SupplierBasicDTO> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierBasicDTO> suppliers) {
        this.suppliers = suppliers;
    }

    public static ProductWithSuppliersDTO fromEntity(ProductSchema product) {
        ProductWithSuppliersDTO dto = new ProductWithSuppliersDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setBarCode(product.getBarCode());
        dto.setDescription(product.getDescription());
        dto.setCategory(product.getCategory());
        dto.setImgUrl(product.getImgUrl());

        List<SupplierBasicDTO> suppliers = product.getSuppliers().stream()
                .map(supplier -> {
                    SupplierBasicDTO s = new SupplierBasicDTO();
                    s.setId(supplier.getId());
                    s.setCompanyName(supplier.getCompanyName());
                    s.setCnpj(supplier.getCnpj());
                    return s;
                }).toList();

        dto.setSuppliers(suppliers);
        return dto;
    }
}
