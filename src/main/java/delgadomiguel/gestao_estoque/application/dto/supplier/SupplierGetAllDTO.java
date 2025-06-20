package delgadomiguel.gestao_estoque.application.dto.supplier;

import delgadomiguel.gestao_estoque.infra.schema.SupplierSchema;

import java.util.UUID;

public record SupplierGetAllDTO (
        UUID id,
        String companyName,
        String cnpj,
        String address,
        String phone,
        String email,
        Boolean isActive,
        String mainContact
)
{
    public static SupplierGetAllDTO fromSchema(SupplierSchema schema) {
        return new SupplierGetAllDTO(
                schema.getId(),
                schema.getCompanyName(),
                schema.getCnpj(),
                schema.getAddress(),
                schema.getPhone(),
                schema.getEmail(),
                schema.getIsActive(),
                schema.getMainContact()
        );
    }
}
