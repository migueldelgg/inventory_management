ALTER TABLE suppliers DROP CONSTRAINT IF EXISTS unique_cnpj;

ALTER TABLE suppliers ADD CONSTRAINT unique_cnpj UNIQUE (cnpj);
