package delgadomiguel.gestao_estoque.application.implementation;

import delgadomiguel.gestao_estoque.domain.model.complement.ProductCategory;

public class ProductCategoryParser {

    public static ProductCategory executeParseCategory(String input) {
        for (ProductCategory category : ProductCategory.values()) {
            if (category.name().equalsIgnoreCase(input) || category.getLabel().equalsIgnoreCase(input)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Categoria inválida: " + input);
    }

}
