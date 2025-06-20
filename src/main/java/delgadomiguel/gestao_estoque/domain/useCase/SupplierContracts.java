package delgadomiguel.gestao_estoque.domain.useCase;

import delgadomiguel.gestao_estoque.application.dto.supplier.CreateSupplierDTO;
import delgadomiguel.gestao_estoque.application.dto.supplier.SupplierGetAllDTO;
import delgadomiguel.gestao_estoque.application.dto.supplier.UpdateSupplierDTO;
import delgadomiguel.gestao_estoque.infra.schema.SupplierSchema;

import java.util.List;

public interface SupplierContracts {

    public List<SupplierGetAllDTO> get();
    public SupplierSchema register(CreateSupplierDTO supplierDTO);
    public void update(String id, UpdateSupplierDTO dto);
    public void deleteById(String id);

    public void supplierExist();
}
