package delgadomiguel.gestao_estoque.application.dto.supplier;

import delgadomiguel.gestao_estoque.domain.model.Supplier;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public record UpdateSupplierDTO(

        Optional<String> companyName,

        Optional<String> cnpj,

        Optional<String> address,

        Optional<String> phone,

        Optional<String> email,

        Optional<String> mainContact
) {
    public Supplier toDomain(Supplier original){
        return new Supplier(
                address.orElse(original.getAddress()),
                cnpj.orElse(original.getCnpj()),
                companyName.orElse(original.getCompanyName()),
                email.orElse(original.getEmail()),
                mainContact.orElse(original.getMainContact()),
                phone.orElse(original.getPhone())
        );
    }
}
