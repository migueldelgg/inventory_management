package delgadomiguel.gestao_estoque.infra.repository;

import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductSchema, UUID> {

    List<ProductSchema> findAllByIsActiveTrue();

}
