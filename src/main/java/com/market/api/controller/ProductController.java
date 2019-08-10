package com.market.api.controller;

import com.market.api.entity.Product;
import com.market.api.entity.User;
import com.market.api.exception.ProductNotFoundException;
import com.market.api.exception.UserNotFoundException;
import com.market.api.service.IProductService;
import com.market.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IUserService userService;

    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(name = "id") Long id) throws ProductNotFoundException {
        Product product = productService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/users/{id}/products")
    public ResponseEntity<Product> addProduct(@PathVariable(name = "id") Long id,
                                              @Valid @RequestBody Product product) throws UserNotFoundException {
        User seller = userService.getUser(id);
        product.setSeller(seller);
        Product savedProduct = productService.addProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable(name = "id") Long id) throws ProductNotFoundException {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product, @PathVariable(name = "id") Long id)
    {
        Product updatedProduct = productService.updateProduct(product, id);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

}
