package delgadomiguel.gestao_estoque.application.implementation;

import delgadomiguel.gestao_estoque.application.dto.product.CreateProductDTO;
import delgadomiguel.gestao_estoque.domain.exception.ProductValidationException;
import delgadomiguel.gestao_estoque.domain.model.Product;
import delgadomiguel.gestao_estoque.domain.useCase.ProductContracts;
import delgadomiguel.gestao_estoque.infra.repository.ProductRepository;
import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ProductContractsImpl implements ProductContracts {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<ProductSchema> getAll() {
        return repository.findAllByIsActiveTrue();
    }

    @Override
    public void register(CreateProductDTO productDTO) {

        Product product = productDTO.toDomain();

        if (product.IsAlreadyExpired()) {
            throw new ProductValidationException();
        }

        ProductSchema productSchema = ProductSchema.fromDomain(product);
        repository.save(productSchema);
    }

    @Override
    public void update() {

    }

    @Override
    public void deleteById(String id) {
        ProductSchema product = repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        product.setIsActive(false);
        repository.save(product);    }
}
