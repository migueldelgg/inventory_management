package delgadomiguel.gestao_estoque.domain.model.complement;

public enum ProductCategory {
    ELETRONICOS("Eletrônicos"),
    ALIMENTOS("Alimentos"),
    VESTUARIO("Vestuário"),
    MOVEIS("Móveis"),
    LIVROS("Livros"),
    HIGIENE("Higiene"),
    BEBIDAS("Bebidas"),
    BRINQUEDOS("Brinquedos"),
    ESPORTES("Esportes"),
    OUTROS("Outros");

    private final String label;

    ProductCategory(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

