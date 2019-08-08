package com.market.api.service;

import com.market.api.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();

    Product getProduct(Long id);

    Product addProduct(Product product);

    void deleteProductById(Long id);

    Product updateProduct(Product product, Long id);

}
