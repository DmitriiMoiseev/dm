package ru.geekbrains.persist;

import ru.geekbrains.service.ProductRepr;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String price;

    public Product() {
    }

    public Product(String productName, String description, String price) {
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public Product(ProductRepr pr) {
        this.id = pr.getId();
        this.productName = pr.getProductName();
        this.description = pr.getDescription();
        this.price = pr.getPrice();
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
