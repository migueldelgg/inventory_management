package delgadomiguel.gestao_estoque.domain.model;

import java.util.Date;

public class Product {

    private String name;
    private String barCode;
    private String description;
    private Integer stockQuantity; // vale a pena se validar
    private String category; // vale a pena se validar
    private Date productValidity; // vale a pena se validar
    private String imgUrl;

    public Product(String barCode, String category,
                   String description, String imgUrl,
                   String name, Date productValidity,
                   Integer stockQuantity) {
        this.barCode = barCode;
        this.category = category;
        this.description = description;
        this.imgUrl = imgUrl;
        this.name = name;
        this.productValidity = productValidity;
        this.stockQuantity = stockQuantity;
    }
}
