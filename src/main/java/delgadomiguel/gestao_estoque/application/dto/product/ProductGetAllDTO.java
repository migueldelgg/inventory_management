package delgadomiguel.gestao_estoque.application.dto.product;

import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;

import java.util.Date;
import java.util.UUID;

public record ProductGetAllDTO(
        UUID id,
        String name,
        String barCode,
        String description,
        Integer stockQuantity,
        String category,
        Boolean isActive,
        Date productValidity,
        String imgUrl
) {
    public static ProductGetAllDTO fromSchema(ProductSchema schema) {
        return new ProductGetAllDTO(
                schema.getId(),
                schema.getName(),
                schema.getBarCode(),
                schema.getDescription(),
                schema.getStockQuantity(),
                schema.getCategory(),
                schema.getIsActive(),
                schema.getProductValidity(),
                schema.getImgUrl()
        );
    }
}
