package delgadomiguel.gestao_estoque.domain.useCase;

import delgadomiguel.gestao_estoque.application.dto.ProductAndSuppliersDTO;
import delgadomiguel.gestao_estoque.application.dto.ProductWithSuppliersDTO;
import delgadomiguel.gestao_estoque.application.dto.SupplierAndProductsDTO;

import java.util.List;

public interface ProductSupplierContracts {

    public ProductAndSuppliersDTO linkSupplierToProduct(String productId, String supplierId);
    public void unlinkSupplierFromProduct(String productId, String supplierId);

    public ProductAndSuppliersDTO getSuppliersFromProductId(String productId);
    public SupplierAndProductsDTO getProductsFromSupplierId(String supplierId);

    public List<ProductWithSuppliersDTO> getAllProductsWithSuppliers();


    /*
    POST /products/{productId}/suppliers/{supplierId} → associar
    DELETE /products/{productId}/suppliers/{supplierId} → desassociar
    GET /products/{productId}/suppliers → listar fornecedores de um produto
    GET /suppliers/{supplierId}/products → listar produtos de um fornecedor
    */

}
