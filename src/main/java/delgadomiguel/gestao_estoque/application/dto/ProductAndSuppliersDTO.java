package delgadomiguel.gestao_estoque.application.dto;

import delgadomiguel.gestao_estoque.application.dto.supplier.SupplierGetAllDTO;
import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public record ProductAndSuppliersDTO(
        UUID id,
        String name,
        String barCode,
        String description,
        Integer stockQuantity,
        String category,
        Boolean isActive,
        Date productValidity,
        String imgUrl,
        Date createdAt,
        Date updatedAt,
        Instant timestamp,
        List<SupplierGetAllDTO> suppliers
) {

    public static ProductAndSuppliersDTO fromSchema(ProductSchema productSchema){
        List<SupplierGetAllDTO> suppliers = productSchema.getSuppliers()
                .stream()
                .map(SupplierGetAllDTO::fromSchema)
                .toList();

        return new ProductAndSuppliersDTO(
                productSchema.getId(),
                productSchema.getName(),
                productSchema.getBarCode(),
                productSchema.getDescription(),
                productSchema.getStockQuantity(),
                productSchema.getCategory(),
                productSchema.getIsActive(),
                productSchema.getProductValidity(),
                productSchema.getImgUrl(),
                productSchema.getCreatedAt(),
                productSchema.getUpdatedAt(),
                Instant.now(),
                suppliers
        );
    }

}
