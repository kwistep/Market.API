package com.market.api.service;

import com.market.api.entity.Product;
import com.market.api.entity.User;
import com.market.api.entity.util.Status;
import com.market.api.exception.ProductHasAlreadyBeenPublished;
import com.market.api.exception.ProductNotFoundException;
import com.market.api.exception.UserNotFoundException;
import com.market.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IUserService userService;

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
    public Product addProduct(Product product, Long userId) throws UserNotFoundException {
        User seller = userService.getUser(userId);
        product.setStatus(Status.NEW.getStatus());
        product.setSeller(seller);
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

    @Override
    public void publishProduct(Long id) throws ProductNotFoundException, ProductHasAlreadyBeenPublished {
        Optional<Product> productTarget = productRepository.findById(id);

        if(productTarget.isPresent())
        {
            Product product = productTarget.get();
            String currentStatus = product.getStatus();

            if( currentStatus.equals(Status.PUBLISHED.getStatus()) )
                throw new ProductHasAlreadyBeenPublished("The product [" + id + " has already been published!]");
            else
                product.setStatus(Status.PUBLISHED.getStatus());


            productRepository.save(product);

        }
        else
        {
            throw new ProductNotFoundException("The product [" + id + "] doesn't exist.");
        }

    }
}
