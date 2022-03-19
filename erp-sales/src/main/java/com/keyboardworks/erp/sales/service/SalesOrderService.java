package com.keyboardworks.erp.sales.service;

import com.keyboardworks.common.dto.request.purchasing.PurchaseOrderRequest;
import com.keyboardworks.common.dto.request.sales.SalesOrderRequest;
import com.keyboardworks.common.dto.response.purchasing.PurchaseOrderResponse;
import com.keyboardworks.common.dto.response.sales.SalesOrderResponse;

public interface SalesOrderService {

    SalesOrderResponse createSalesOrder(SalesOrderRequest request);

}
