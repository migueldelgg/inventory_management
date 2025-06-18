package delgadomiguel.gestao_estoque.application.dto.supplier;

import delgadomiguel.gestao_estoque.domain.model.Supplier;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateSupplierDTO(

        @NotBlank(message = "O nome do fornecedor é obrigatório")
        String companyName,

        @NotBlank(message = "O cnpj do fornecedor é obrigatório")
        String cnpj,

        @NotBlank(message = "O endereço do fornecedor é obrigatório")
        String address,

        @NotNull(message = "O telefone é obrigatório")
        String phone,

        @NotNull(message = "O email é obrigatório")
        String email,

        @NotNull
        String mainContact
) {
    public Supplier toDomain(){
        return new Supplier(
                this.address,
                this.cnpj,
                this.companyName,
                this.email,
                this.mainContact,
                this.phone
        );
    }
}
