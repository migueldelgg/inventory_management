package delgadomiguel.gestao_estoque.application.http;

import delgadomiguel.gestao_estoque.application.dto.product.CreateProductDTO;
import delgadomiguel.gestao_estoque.domain.useCase.ProductContracts;
import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductContracts productContracts;

    public ProductController(ProductContracts productContracts) {
        this.productContracts = productContracts;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerProduct(@RequestBody @Valid CreateProductDTO productDTO) {
        productContracts.register(productDTO);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductSchema> getAll() {
        return productContracts.getAll();
    }
}
