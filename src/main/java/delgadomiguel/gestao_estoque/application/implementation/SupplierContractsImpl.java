package delgadomiguel.gestao_estoque.application.implementation;

import delgadomiguel.gestao_estoque.application.dto.supplier.CreateSupplierDTO;
import delgadomiguel.gestao_estoque.domain.model.Supplier;
import delgadomiguel.gestao_estoque.domain.useCase.SupplierContracts;
import delgadomiguel.gestao_estoque.infra.repository.SupplierRepository;
import delgadomiguel.gestao_estoque.infra.schema.SupplierSchema;
import org.springframework.stereotype.Service;

@Service
public class SupplierContractsImpl implements SupplierContracts {

    private final SupplierRepository repository;

    public SupplierContractsImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public void get() {

    }

    @Override
    public SupplierSchema register(CreateSupplierDTO createSupplierDTO) {
        Supplier supplier = createSupplierDTO.toDomain();
        SupplierSchema supplierSchema = SupplierSchema.fromDomain(supplier);

        System.out.println("Salvando no banco: " + supplierSchema);

        return repository.save(supplierSchema);
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void supplierExist() {

    }
}
