package delgadomiguel.gestao_estoque.application.mappers;

import delgadomiguel.gestao_estoque.application.implementation.utils.ProductCategoryParser;
import delgadomiguel.gestao_estoque.domain.model.Product;
import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;

public class ProductMapper {
    public static Product toDomain(ProductSchema schema) {
        return new Product(
                schema.getName(),
                schema.getBarCode(),
                ProductCategoryParser.executeParseCategory(schema.getCategory()), // lógica de domínio
                schema.getDescription(),
                schema.getImgUrl(),
                schema.getProductValidity(),
                schema.getStockQuantity()
        );
    }
}
