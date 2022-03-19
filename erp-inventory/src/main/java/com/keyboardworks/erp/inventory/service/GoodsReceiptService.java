package com.keyboardworks.erp.inventory.service;

import com.keyboardworks.common.dto.response.inventory.GoodsReceiptResponse;
import com.keyboardworks.common.dto.response.purchasing.PurchaseOrderResponse;

public interface GoodsReceiptService {

    GoodsReceiptResponse createGoodsReceipt(PurchaseOrderResponse request);

}
