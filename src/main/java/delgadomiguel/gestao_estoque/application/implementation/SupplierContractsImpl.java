package delgadomiguel.gestao_estoque.application.implementation;

import delgadomiguel.gestao_estoque.application.dto.supplier.CreateSupplierDTO;
import delgadomiguel.gestao_estoque.application.dto.supplier.SupplierGetAllDTO;
import delgadomiguel.gestao_estoque.domain.model.Supplier;
import delgadomiguel.gestao_estoque.domain.useCase.SupplierContracts;
import delgadomiguel.gestao_estoque.infra.repository.SupplierRepository;
import delgadomiguel.gestao_estoque.infra.schema.ProductSchema;
import delgadomiguel.gestao_estoque.infra.schema.SupplierSchema;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class SupplierContractsImpl implements SupplierContracts {

    private final SupplierRepository repository;

    public SupplierContractsImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SupplierGetAllDTO> get() {
        return repository.findAll()
                .stream()
                .map(SupplierGetAllDTO::fromSchema)
                .toList();
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
    public void deleteById(String id) {
        SupplierSchema supplierSchema = repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));

        supplierSchema.setIsActive(false);
        repository.save(supplierSchema);
    }

    @Override
    public void supplierExist() {
    }
}
