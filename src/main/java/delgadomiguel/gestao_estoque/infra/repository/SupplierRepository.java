package delgadomiguel.gestao_estoque.infra.repository;

import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;
import delgadomiguel.gestao_estoque.infra.schema.SupplierSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierSchema, UUID> {

    List<SupplierSchema> findAllByIsActiveTrue();

}
