ALTER TABLE suppliers
ADD CONSTRAINT uq_suppliers_cnpj UNIQUE (cnpj);
