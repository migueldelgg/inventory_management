package delgadomiguel.gestao_estoque.application.implementation;

import delgadomiguel.gestao_estoque.application.dto.product.CreateProductDTO;
import delgadomiguel.gestao_estoque.domain.exception.ProductValidationException;
import delgadomiguel.gestao_estoque.domain.model.Product;
import delgadomiguel.gestao_estoque.domain.useCase.ProductContracts;
import delgadomiguel.gestao_estoque.infra.repository.ProductRepository;
import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductContractsImpl implements ProductContracts {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<ProductSchema> get() {
        return repository.findAll();
    }

    @Override
    public void register(CreateProductDTO productDTO) {

        Product product = productDTO.toDomain();

        if (product.productIsAlreadyExpired()) {
            throw new ProductValidationException();
        }

        ProductSchema productSchema = ProductSchema.fromDomain(product);
        repository.save(productSchema);
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
