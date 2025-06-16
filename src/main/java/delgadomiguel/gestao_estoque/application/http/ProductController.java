package delgadomiguel.gestao_estoque.application.http;

import delgadomiguel.gestao_estoque.application.dto.product.CreateProductDTO;
import delgadomiguel.gestao_estoque.domain.useCase.ProductContracts;
import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestParam String id) {
        productContracts.deleteById(id);
    }
}
