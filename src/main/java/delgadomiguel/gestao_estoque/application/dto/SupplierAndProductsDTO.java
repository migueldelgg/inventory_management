package delgadomiguel.gestao_estoque.application.dto;

import delgadomiguel.gestao_estoque.application.dto.product.ProductGetAllDTO;
import delgadomiguel.gestao_estoque.infra.schema.SupplierSchema;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public record SupplierAndProductsDTO(
        UUID id,
        String companyName,
        String cnpj,
        String address,
        String phone,
        String email,
        Boolean isActive,
        String mainContact,
        Date createdAt,
        Date updatedAt,
        Instant timestamp,
        List<ProductGetAllDTO> products
) {

    public static SupplierAndProductsDTO fromSchema(SupplierSchema supplierSchema){
        List<ProductGetAllDTO> products = supplierSchema.getProducts()
                .stream()
                .map(ProductGetAllDTO::fromSchema)
                .toList();

        return new SupplierAndProductsDTO(
                supplierSchema.getId(),
                supplierSchema.getCompanyName(),
                supplierSchema.getCnpj(),
                supplierSchema.getAddress(),
                supplierSchema.getPhone(),
                supplierSchema.getEmail(),
                supplierSchema.getIsActive(),
                supplierSchema.getMainContact(),
                supplierSchema.getCreatedAt(),
                supplierSchema.getUpdatedAt(),
                Instant.now(),
                products
        );
    }
}
