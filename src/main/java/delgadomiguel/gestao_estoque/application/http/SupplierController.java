package delgadomiguel.gestao_estoque.application.http;

import delgadomiguel.gestao_estoque.application.dto.supplier.CreateSupplierDTO;
import delgadomiguel.gestao_estoque.domain.useCase.SupplierContracts;
import delgadomiguel.gestao_estoque.infra.schema.SupplierSchema;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierContracts supplierContracts;

    public SupplierController(SupplierContracts supplierContracts) {
        this.supplierContracts = supplierContracts;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public SupplierSchema registerSupplier(@RequestBody @Valid CreateSupplierDTO supplierDTO) {
        System.out.println(supplierDTO);
        return supplierContracts.register(supplierDTO);
    }
}
