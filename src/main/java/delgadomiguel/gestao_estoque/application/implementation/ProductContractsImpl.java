package delgadomiguel.gestao_estoque.application.implementation;

import delgadomiguel.gestao_estoque.application.dto.product.CreateProductDTO;
import delgadomiguel.gestao_estoque.application.dto.product.ProductGetAllDTO;
import delgadomiguel.gestao_estoque.application.dto.product.UpdateProductDTO;
import delgadomiguel.gestao_estoque.domain.exception.ProductValidationException;
import delgadomiguel.gestao_estoque.domain.model.Product;
import delgadomiguel.gestao_estoque.domain.model.complement.ProductValidity;
import delgadomiguel.gestao_estoque.domain.useCase.ProductContracts;
import delgadomiguel.gestao_estoque.infra.repository.ProductRepository;
import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static delgadomiguel.gestao_estoque.application.implementation.utils.ProductCategoryParser.executeParseCategory;

@Service
public class ProductContractsImpl implements ProductContracts {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<ProductGetAllDTO> getAll() {
        return repository.findAllByIsActiveTrue()
                .stream()
                .map(ProductGetAllDTO::fromSchema)
                .toList();
    }

    @Override
    public void register(CreateProductDTO productDTO) {

        Product product = productDTO.toDomain();
        product.validateExpiration();

        ProductSchema productSchema = ProductSchema.fromDomain(product);
        repository.save(productSchema);
    }

    @Override
    @Transactional
    public void update(String id, UpdateProductDTO dto) {
        ProductSchema schema = repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        Product domain = dto.toDomain(schema.toDomain());
        domain.validateExpiration();

        schema.updateFromDomain(domain);
    }

    @Override
    public void deleteById(String id) {
        ProductSchema product = repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        product.setIsActive(false);
        repository.save(product);
    }

    public static void validateExpiration(Date validityDate) {
        if (new ProductValidity(validityDate).isExpired(validityDate)) {
            throw new ProductValidationException();
        }
    }
}
