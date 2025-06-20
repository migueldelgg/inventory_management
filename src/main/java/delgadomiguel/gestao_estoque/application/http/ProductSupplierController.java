package delgadomiguel.gestao_estoque.application.http;

import delgadomiguel.gestao_estoque.application.dto.ProductAndSuppliersDTO;
import delgadomiguel.gestao_estoque.domain.useCase.ProductSupplierContracts;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductSupplierController {

    private final ProductSupplierContracts productSupplierContracts;

    public ProductSupplierController(ProductSupplierContracts productSupplierContracts) {
        this.productSupplierContracts = productSupplierContracts;
    }

    @PostMapping("/{productId}/supplier/{supplierId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductAndSuppliersDTO linkSupplierToProduct(
            @PathVariable String productId,
            @PathVariable String supplierId
    ) {
        return productSupplierContracts.linkSupplierToProduct(productId, supplierId);
    }

    @DeleteMapping("/{productId}/supplier/{supplierId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unlinkSupplierFromProduct(
            @PathVariable String productId,
            @PathVariable String supplierId
    ) {
        productSupplierContracts.unlinkSupplierFromProduct(productId, supplierId);
    }

    @GetMapping("/{productId}/suppliers")
    @ResponseStatus(HttpStatus.OK)
    public ProductAndSuppliersDTO getSuppliersFromProductId(@PathVariable String productId) {
        return productSupplierContracts.getSuppliersFromProductId(productId);
    }
}
