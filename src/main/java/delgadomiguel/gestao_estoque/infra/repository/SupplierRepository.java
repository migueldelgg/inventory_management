package delgadomiguel.gestao_estoque.infra.repository;

import delgadomiguel.gestao_estoque.infra.schema.SupplierSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierSchema, UUID> {
}
