package delgadomiguel.gestao_estoque.application.http;

import delgadomiguel.gestao_estoque.application.dto.product.CreateProductDTO;
import delgadomiguel.gestao_estoque.application.dto.product.ProductGetAllDTO;
import delgadomiguel.gestao_estoque.application.dto.product.UpdateProductDTO;
import delgadomiguel.gestao_estoque.domain.useCase.ProductContracts;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductContracts productContracts;

    public ProductController(ProductContracts productContracts) {
        this.productContracts = productContracts;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerProduct(@RequestBody @Valid CreateProductDTO productDTO) {
        System.out.println("Criou produto");
        productContracts.register(productDTO);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductGetAllDTO> getAll() {
        System.out.println("buscou todos os produtos");
        return productContracts.getAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatedProduct(@PathVariable String id, @RequestBody UpdateProductDTO updateProductDTO) {
        System.out.println("requisicao recebida \n"+ updateProductDTO);
        productContracts.update(id, updateProductDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        System.out.println("requisicao recebida: id == "+ id);
        productContracts.deleteById(id);
    }
}
