package com.keyboardworks.erp.sales.controller;

import com.keyboardworks.common.dto.request.sales.SalesOrderRequest;
import com.keyboardworks.common.dto.response.sales.SalesOrderResponse;
import com.keyboardworks.erp.sales.service.SalesOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sales-order")
@RequiredArgsConstructor
public class SalesOrderController {

    private final SalesOrderService service;

    @PostMapping
    public SalesOrderResponse createSalesOrder(@RequestBody SalesOrderRequest request) {
        return service.createSalesOrder(request);
    }

}
