package ru.geekbrains.service;

import ru.geekbrains.persist.Product;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

public class ProductRepr {

    private Long id;

    @NotEmpty
    private String productName;

    @NotEmpty
    private String description;

    @NotEmpty
    private String price;

    public ProductRepr() {
    }

    public ProductRepr(String productName, String description, String price) {
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public ProductRepr(Product product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
