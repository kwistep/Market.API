package com.market.api.service;

import com.market.api.entity.ProductOrder;
import com.market.api.exception.ProductOrderNotFoundException;

import java.util.List;

public interface IProductOrderService {

    List<ProductOrder> getAllProductOrders();

    ProductOrder getProductOrder(Long id) throws ProductOrderNotFoundException;

    ProductOrder addProductOrder(ProductOrder ProductOrder);

    void deleteProductOrderById(Long id) throws ProductOrderNotFoundException;

    ProductOrder updateProductOrder(ProductOrder ProductOrder, Long id);

}
