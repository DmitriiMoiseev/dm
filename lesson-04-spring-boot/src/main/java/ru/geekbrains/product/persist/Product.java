package ru.geekbrains.product.persist;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

public class Product {

    private Long id;

    @NotEmpty
    private String productName;

    @NotEmpty
    private String description;

    public Product() {

    }

    public Product(String productName) {
        this.productName = productName;
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
}
