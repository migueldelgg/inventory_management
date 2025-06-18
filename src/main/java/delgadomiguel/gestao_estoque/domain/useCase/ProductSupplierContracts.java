package delgadomiguel.gestao_estoque.domain.useCase;

public interface ProductSupplierContracts {

    public void linkSupplierToProduct();
    public void unlinkSupplierFromProduct();

    public void getSuppliersFromProduct();
    public void getProductsFromSupplier();

    /*
    POST /products/{productId}/suppliers/{supplierId} → associar
    DELETE /products/{productId}/suppliers/{supplierId} → desassociar
    GET /products/{productId}/suppliers → listar fornecedores de um produto
    GET /suppliers/{supplierId}/products → listar produtos de um fornecedor
    */

}
