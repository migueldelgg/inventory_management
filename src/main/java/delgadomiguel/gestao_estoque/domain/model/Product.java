package delgadomiguel.gestao_estoque.domain.model;

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

    public Product(String name, String barCode, String category,
                   String description, String imgUrl,
                   Date productValidity, Integer stockQuantity) {
        this.barCode = barCode;
        this.category = ProductCategory.valueOf(category);
        this.description = description;
        this.imgUrl = imgUrl;
        this.name = name;
        this.productValidity = new ProductValidity(productValidity);
        this.stockQuantity = stockQuantity;
    }

    public boolean productIsAlreadyExpired(){
        return this.productValidity.isAlreadyExpired(this.productValidity.getProductValidity());
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
