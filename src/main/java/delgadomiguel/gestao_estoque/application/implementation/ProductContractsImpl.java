package delgadomiguel.gestao_estoque.application.implementation;

import delgadomiguel.gestao_estoque.application.dto.product.CreateProductDTO;
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
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static delgadomiguel.gestao_estoque.application.implementation.ProductCategoryParser.executeParseCategory;

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
        product.validateExpiration();

        ProductSchema productSchema = ProductSchema.fromDomain(product);
        repository.save(productSchema);
    }

    @Override
    public void update(String id, UpdateProductDTO dto) {
        ProductSchema product = repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        dto.productValidity().ifPresent(date -> validateExpiration(date));

        // Atualiza os campos, apenas se presentes
        dto.name().ifPresent(product::setName);
        dto.barCode().ifPresent(product::setBarCode);
        dto.description().ifPresent(product::setDescription);
        dto.stockQuantity().ifPresent(product::setStockQuantity);
        dto.imgUrl().ifPresent(product::setImgUrl);
        dto.productValidity().ifPresent(product::setProductValidity);
        dto.category().ifPresent(categoryStr -> {
            product.setCategory(executeParseCategory(categoryStr).getLabel());
        });
        repository.save(product);
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
