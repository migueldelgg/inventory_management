package delgadomiguel.gestao_estoque.domain.useCase;

import delgadomiguel.gestao_estoque.application.dto.product.CreateProductDTO;
import delgadomiguel.gestao_estoque.application.dto.product.ProductGetAllDTO;
import delgadomiguel.gestao_estoque.application.dto.product.UpdateProductDTO;

import java.util.List;

public interface ProductContracts {

    public List<ProductGetAllDTO> getAll();
    public void register(CreateProductDTO productDTO);
    public void update(String id, UpdateProductDTO updateProductDTO);
    public void deleteById(String id);

}
