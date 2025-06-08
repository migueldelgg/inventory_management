package delgadomiguel.gestao_estoque.application.dto.product;

import delgadomiguel.gestao_estoque.domain.model.complement.ProductCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Date;

public record CreateProductDTO(

        @NotBlank(message = "O nome do produto é obrigatório")
        String name,

        @NotBlank(message = "O código de barras é obrigatório")
        String barCode,

        @NotBlank(message = "A descrição do produto é obrigatória")
        String description,

        @NotNull(message = "A quantidade em estoque é obrigatória")
        @PositiveOrZero(message = "A quantidade em estoque não pode ser negativa")
        Integer stockQuantity,

        @NotBlank(message = "A categoria do produto é obrigatória")
        ProductCategory category,

        // Validade é opcional, mas pode ser validada com lógica adicional, se necessário
        Date productValidity,

        // A imagem é opcional, mas pode ter validação se necessário (como extensão ou tamanho)
        String imgUrl

) {}

