package delgadomiguel.gestao_estoque.domain.useCase;

import delgadomiguel.gestao_estoque.application.dto.supplier.CreateSupplierDTO;
import delgadomiguel.gestao_estoque.infra.schema.SupplierSchema;

public interface SupplierContracts {

    public void get();
    public SupplierSchema register(CreateSupplierDTO supplierDTO);
    public void update();
    public void delete();

    public void supplierExist();
}
