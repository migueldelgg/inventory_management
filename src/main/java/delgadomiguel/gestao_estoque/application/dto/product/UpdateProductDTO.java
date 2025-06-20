package delgadomiguel.gestao_estoque.application.dto.product;

import delgadomiguel.gestao_estoque.domain.model.Product;

import java.util.Date;
import java.util.Optional;

import static delgadomiguel.gestao_estoque.application.implementation.utils.ProductCategoryParser.executeParseCategory;

public record UpdateProductDTO(

        Optional<String> name,

        Optional<String> barCode,

        Optional<String> description,

        Optional<Integer> stockQuantity,

        Optional<String> category,

        Optional<Date> productValidity,

        Optional<String> imgUrl

) {
        public Product toDomain(Product original) {
                return new Product(
                        name.orElse(original.getName()),
                        barCode.orElse(original.getBarCode()),
                        category.map(categoryToParse -> executeParseCategory(categoryToParse)).orElse(original.getCategory()),
                        description.orElse(original.getDescription()),
                        imgUrl.orElse(original.getImgUrl()),
                        productValidity.orElse(original.getProductValidity().getValue()),
                        stockQuantity.orElse(original.getStockQuantity())
                );
        }


}

