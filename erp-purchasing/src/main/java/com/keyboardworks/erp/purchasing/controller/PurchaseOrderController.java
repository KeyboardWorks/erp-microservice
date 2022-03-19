package com.keyboardworks.erp.purchasing.controller;

import com.keyboardworks.common.dto.request.purchasing.PurchaseOrderRequest;
import com.keyboardworks.common.dto.response.purchasing.PurchaseOrderResponse;
import com.keyboardworks.erp.purchasing.service.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/purchase-order")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    @PostMapping
    public PurchaseOrderResponse createPurchaseOrder(@RequestBody PurchaseOrderRequest request) {
        return service.createPurchaseOrder(request);
    }

}
