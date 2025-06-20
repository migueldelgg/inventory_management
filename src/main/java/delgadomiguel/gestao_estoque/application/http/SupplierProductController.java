package delgadomiguel.gestao_estoque.application.http;

import delgadomiguel.gestao_estoque.application.dto.SupplierAndProductsDTO;
import delgadomiguel.gestao_estoque.domain.useCase.ProductSupplierContracts;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierProductController {

    private final ProductSupplierContracts productSupplierContracts;

    public SupplierProductController(ProductSupplierContracts productSupplierContracts) {
        this.productSupplierContracts = productSupplierContracts;
    }

    @GetMapping("/{supplierId}/products")
    @ResponseStatus(HttpStatus.OK)
    public SupplierAndProductsDTO getProductsFromSupplierId(@PathVariable String supplierId) {
        return productSupplierContracts.getProductsFromSupplierId(supplierId);
    }

}
