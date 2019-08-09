package com.market.api.service;

import com.market.api.entity.Product;
import com.market.api.exception.ProductNotFoundException;

import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();

    Product getProduct(Long id) throws ProductNotFoundException;

    Product addProduct(Product product);

    void deleteProductById(Long id) throws ProductNotFoundException;

    Product updateProduct(Product product, Long id);

}
