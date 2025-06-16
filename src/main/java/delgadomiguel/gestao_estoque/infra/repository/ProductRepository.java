package delgadomiguel.gestao_estoque.infra.repository;

import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductSchema, UUID> {

    List<ProductSchema> findAllByIsActiveTrue();

}
