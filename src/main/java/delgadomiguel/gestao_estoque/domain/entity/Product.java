package delgadomiguel.gestao_estoque.domain.entity;

import java.util.Date;

public class Product {

    private String name;
    private String barCode;
    private String description;
    private Integer stockQuantity; // vale a pena se validar
    private String category; // vale a pena se validar
    private Date productValidity; // vale a pena se validar
    private String imgUrl;

}
