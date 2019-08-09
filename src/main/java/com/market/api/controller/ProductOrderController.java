package com.market.api.controller;

import com.market.api.entity.ProductOrder;
import com.market.api.exception.ProductOrderNotFoundException;
import com.market.api.service.IProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductOrderController {

    @Autowired
    private IProductOrderService productOrderService;

    @GetMapping("/orders")
    public List<ProductOrder> getAllProductOrders()
    {
        return productOrderService.getAllProductOrders();
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<ProductOrder> getProductOrder(@PathVariable(name = "id") Long id) throws ProductOrderNotFoundException {
        ProductOrder productOrder = productOrderService.getProductOrder(id);
        return new ResponseEntity<>(productOrder, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<ProductOrder> addProductOrder(@RequestBody ProductOrder productOrder)
    {
        ProductOrder savedProductOrder = productOrderService.addProductOrder(productOrder);
        return new ResponseEntity<>(savedProductOrder, HttpStatus.CREATED);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity deleteProductOrder(@PathVariable(name = "id") Long id) throws ProductOrderNotFoundException {
        productOrderService.deleteProductOrderById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<ProductOrder> updateProductOrder(@RequestBody ProductOrder productOrder, @PathVariable(name = "id") Long id)
    {
        ProductOrder updatedProductOrder = productOrderService.updateProductOrder(productOrder, id);
        return new ResponseEntity<>(updatedProductOrder, HttpStatus.OK);
    }

}
