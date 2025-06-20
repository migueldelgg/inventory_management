package delgadomiguel.gestao_estoque.application.dto.product;

import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;

import java.time.Instant;
import java.util.List;

public record LinkSupplierToProductResDTO(
        String productName,
        List<String> suppliers,
        Instant timestamp
) {

    public static LinkSupplierToProductResDTO fromSchema(ProductSchema productSchema){
        List<String> supplierNames = productSchema.getSuppliers()
                .stream()
                .map(supplier -> supplier.getCompanyName())
                .toList();

        return new LinkSupplierToProductResDTO(
                productSchema.getName(),
                supplierNames,
                Instant.now()
        );
    }


}
