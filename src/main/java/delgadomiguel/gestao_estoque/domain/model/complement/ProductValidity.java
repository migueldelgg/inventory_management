package delgadomiguel.gestao_estoque.domain.model.complement;

import java.time.Instant;
import java.util.Date;

public class ProductValidity {

    private Date productValidity;

    public ProductValidity(Date productValidity) {
        this.productValidity = productValidity;
    }

    public Date getValue() {
        return productValidity;
    }

    public boolean isExpired(Date productValidity){
        var limit = Date.from(Instant.now());

        if (productValidity.after(limit)) {
            return false;
        }

        return true;
    }
}
