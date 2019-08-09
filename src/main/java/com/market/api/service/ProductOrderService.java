package com.market.api.service;

import com.market.api.entity.ProductOrder;
import com.market.api.exception.ProductOrderNotFoundException;
import com.market.api.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductOrderService implements IProductOrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;


    @Override
    public List<ProductOrder> getAllProductOrders() {
        return productOrderRepository.findAll();
    }

    @Override
    public ProductOrder getProductOrder(Long id) throws ProductOrderNotFoundException {
        Optional<ProductOrder> targetProductOrder = productOrderRepository.findById(id);

        if( targetProductOrder.isPresent() )
        {
            return targetProductOrder.get();
        }
        else
        {
            throw new ProductOrderNotFoundException("Product order [" + id + "] doesn't exist.");
        }
    }

    @Override
    public ProductOrder addProductOrder(ProductOrder productOrder) {
        return productOrderRepository.save(productOrder);
    }

    @Override
    public void deleteProductOrderById(Long id) throws ProductOrderNotFoundException {

        Optional<ProductOrder> targetProductOrder = productOrderRepository.findById(id);

        if( targetProductOrder.isPresent() )
        {
            ProductOrder productOrder = targetProductOrder.get();
            productOrderRepository.delete(productOrder);
        }
        else
        {
           throw new ProductOrderNotFoundException("Product order [" + id + "] doesn't exist.");
        }


    }

    @Override
    public ProductOrder updateProductOrder(ProductOrder productOrder, Long id) {
        productOrder.setOrderId(id);
        return productOrderRepository.save(productOrder);
    }
}
