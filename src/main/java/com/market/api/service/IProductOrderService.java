package com.market.api.service;

import com.market.api.entity.ProductOrder;

import java.util.List;

public interface IProductOrderService {

    List<ProductOrder> getAllProductOrders();

    ProductOrder getProductOrder(Long id);

    ProductOrder addProductOrder(ProductOrder ProductOrder);

    void deleteProductOrderById(Long id);

    ProductOrder updateProductOrder(ProductOrder ProductOrder, Long id);

}
