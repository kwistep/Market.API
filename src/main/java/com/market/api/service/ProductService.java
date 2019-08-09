package com.market.api.service;

import com.market.api.entity.Product;
import com.market.api.exception.ProductNotFoundException;
import com.market.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) throws ProductNotFoundException {
        Optional<Product> targetProduct = productRepository.findById(id);

        if( targetProduct.isPresent() )
        {
            return targetProduct.get();
        }
        else
        {
            throw new ProductNotFoundException("Product [" + id + "] doesn't exist.");
        }
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) throws ProductNotFoundException {
        Optional<Product> targetProduct = productRepository.findById(id);

        if( targetProduct.isPresent() )
        {
            Product product = targetProduct.get();
            productRepository.delete(product);
        }
        else
        {
            throw new ProductNotFoundException("Product [" + id + "] doesn't exist.");
        }
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        product.setProductId(id);
        return productRepository.save(product);
    }
}
