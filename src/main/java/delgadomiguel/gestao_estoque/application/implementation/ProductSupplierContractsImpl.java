package delgadomiguel.gestao_estoque.application.implementation;

import delgadomiguel.gestao_estoque.application.dto.ProductAndSuppliersDTO;
import delgadomiguel.gestao_estoque.application.dto.SupplierAndProductsDTO;
import delgadomiguel.gestao_estoque.domain.useCase.ProductSupplierContracts;
import delgadomiguel.gestao_estoque.infra.repository.ProductRepository;
import delgadomiguel.gestao_estoque.infra.repository.SupplierRepository;
import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;
import delgadomiguel.gestao_estoque.infra.schema.SupplierSchema;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class ProductSupplierContractsImpl implements ProductSupplierContracts {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public ProductSupplierContractsImpl(ProductRepository productRepository,
                                        SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public ProductAndSuppliersDTO linkSupplierToProduct(String productId, String supplierId) {

        ProductSchema product = productRepository.findById(UUID.fromString(productId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        SupplierSchema supplier = supplierRepository.findById(UUID.fromString(supplierId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));

        product.getSuppliers().add(supplier);
        supplier.getProducts().add(product);

        productRepository.save(product);
        supplierRepository.save(supplier);

        return ProductAndSuppliersDTO.fromSchema(product);
    }

    @Override
    public void unlinkSupplierFromProduct(String productId, String supplierId) {

        ProductSchema product = productRepository.findById(UUID.fromString(productId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        SupplierSchema supplier = supplierRepository.findById(UUID.fromString(supplierId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));

        product.getSuppliers().remove(supplier);
        supplier.getProducts().remove(product);

        productRepository.save(product);
        supplierRepository.save(supplier);
    }

    @Override
    public ProductAndSuppliersDTO getSuppliersFromProductId(String productId) {
        ProductSchema product = productRepository.findById(UUID.fromString(productId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        return ProductAndSuppliersDTO.fromSchema(product);
    }

    @Override
    public SupplierAndProductsDTO getProductsFromSupplierId(String supplierId) {
        SupplierSchema supplier = supplierRepository.findById(UUID.fromString(supplierId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));

        return SupplierAndProductsDTO.fromSchema(supplier);
    }
}
