package delgadomiguel.gestao_estoque.domain.useCase;

import delgadomiguel.gestao_estoque.application.dto.product.CreateProductDTO;
import delgadomiguel.gestao_estoque.application.dto.product.UpdateProductDTO;
import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;

import java.util.List;

public interface ProductContracts {

    public List<ProductSchema> getAll();
    public void register(CreateProductDTO productDTO);
    public void update(String id, UpdateProductDTO updateProductDTO);
    public void deleteById(String id);

}
