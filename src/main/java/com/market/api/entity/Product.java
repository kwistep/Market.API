package com.market.api.entity;

import com.market.api.entity.util.ProductCondition;
import com.market.api.entity.util.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "Product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "productId")
    private Long productId;

    @Column(name = "title")
    private String title;

    @Column(name = "regularPrice")
    private BigDecimal regularPrice;

    @Column(name = "initialPrice")
    private BigDecimal initialPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "color")
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(name = "productCondition", length = 4)
    private ProductCondition productCondition;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 9)
    private Status status;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne(fetch = FetchType.EAGER)
    private User seller;

    @ManyToOne(fetch = FetchType.EAGER)
    private User buyer;

    public Product() {
    }

    public Product(Long productId, String title, BigDecimal regularPrice, BigDecimal initialPrice, String description, String color, ProductCondition productCondition, Status status, Integer stock, User seller, User buyer) {
        this.productId = productId;
        this.title = title;
        this.regularPrice = regularPrice;
        this.initialPrice = initialPrice;
        this.description = description;
        this.color = color;
        this.productCondition = productCondition;
        this.status = status;
        this.stock = stock;
        this.seller = seller;
        this.buyer = buyer;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(BigDecimal regularPrice) {
        this.regularPrice = regularPrice;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ProductCondition getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(ProductCondition productCondition) {
        this.productCondition = productCondition;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId.equals(product.productId) &&
                title.equals(product.title) &&
                regularPrice.equals(product.regularPrice) &&
                Objects.equals(initialPrice, product.initialPrice) &&
                Objects.equals(description, product.description) &&
                Objects.equals(color, product.color) &&
                productCondition == product.productCondition &&
                status == product.status &&
                stock.equals(product.stock) &&
                seller.equals(product.seller) &&
                Objects.equals(buyer, product.buyer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, title, regularPrice, initialPrice, description, color, productCondition, status, stock, seller, buyer);
    }
}
