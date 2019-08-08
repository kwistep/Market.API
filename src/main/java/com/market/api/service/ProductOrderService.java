package com.market.api.service;

import com.market.api.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderService implements IProductOrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

}
