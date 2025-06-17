package delgadomiguel.gestao_estoque.domain.model;

import delgadomiguel.gestao_estoque.domain.exception.ProductValidationException;
import delgadomiguel.gestao_estoque.domain.model.complement.ProductCategory;
import delgadomiguel.gestao_estoque.domain.model.complement.ProductValidity;

import java.util.Date;

public class Product {

    private String name;
    private String barCode;
    private String description;
    private Integer stockQuantity; // vale a pena se validar
    private ProductCategory category; // vale a pena se validar
    private ProductValidity productValidity;
    private String imgUrl;

    public Product(String name, String barCode, ProductCategory category,
                   String description, String imgUrl,
                   Date productValidity, Integer stockQuantity) {

        this.barCode = barCode;
        this.category = category; // já vem como enum, sem fazer valueOf
        this.description = description;
        this.imgUrl = imgUrl;
        this.name = name;
        this.productValidity = new ProductValidity(productValidity);
        this.stockQuantity = stockQuantity;
    }

    public void validateExpiration() {
        if (this.productValidity.isExpired(this.productValidity.getProductValidity())) {
            throw new ProductValidationException();
        }
    }

    public String getBarCode() {
        return barCode;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getName() {
        return name;
    }

    public ProductValidity getProductValidity() {
        return productValidity;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }
}
