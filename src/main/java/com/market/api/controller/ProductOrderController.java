package com.market.api.controller;

import com.market.api.service.IProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductOrderController {

    @Autowired
    private IProductOrderService productOrderService;

}
