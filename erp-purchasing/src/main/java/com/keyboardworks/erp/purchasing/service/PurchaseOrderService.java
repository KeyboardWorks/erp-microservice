package com.keyboardworks.erp.purchasing.service;

import com.keyboardworks.common.dto.request.purchasing.PurchaseOrderRequest;
import com.keyboardworks.common.dto.response.purchasing.PurchaseOrderResponse;

public interface PurchaseOrderService {

    PurchaseOrderResponse createPurchaseOrder(PurchaseOrderRequest request);

}
