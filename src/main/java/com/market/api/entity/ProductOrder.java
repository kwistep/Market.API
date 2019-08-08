package com.market.api.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "ProductOrder")
public class ProductOrder {

    @Id
    @GeneratedValue
    @Column(name = "orderId")
    private Long orderId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User createdBy;

    @ManyToOne(fetch = FetchType.EAGER)
    private User attachedTo;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;


    public ProductOrder() {
    }

    public ProductOrder(User createdBy, User attachedTo, Product product, Integer quantity) {
        this.createdBy = createdBy;
        this.attachedTo = attachedTo;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getAttachedTo() {
        return attachedTo;
    }

    public void setAttachedTo(User attachedTo) {
        this.attachedTo = attachedTo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrder productOrder = (ProductOrder) o;
        return orderId.equals(productOrder.orderId) &&
                createdBy.equals(productOrder.createdBy) &&
                attachedTo.equals(productOrder.attachedTo) &&
                product.equals(productOrder.product) &&
                quantity.equals(productOrder.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, createdBy, attachedTo, product, quantity);
    }
}
