package delgadomiguel.gestao_estoque.domain.useCase;

import delgadomiguel.gestao_estoque.application.dto.product.LinkSupplierToProductResDTO;

public interface ProductSupplierContracts {

    public LinkSupplierToProductResDTO linkSupplierToProduct(String productId, String supplierId);
    public void unlinkSupplierFromProduct(String productId, String supplierId);

    public void getSuppliersFromProduct();
    public void getProductsFromSupplier();

    /*
    POST /products/{productId}/suppliers/{supplierId} → associar
    DELETE /products/{productId}/suppliers/{supplierId} → desassociar
    GET /products/{productId}/suppliers → listar fornecedores de um produto
    GET /suppliers/{supplierId}/products → listar produtos de um fornecedor
    */

}
