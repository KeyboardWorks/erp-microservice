package com.keyboardworks.common.dto.response.inventory;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class GoodsReceiptResponse extends BaseInventoryResponse {

    private String goodsReceiptCode;
    private Set<GoodsReceiptItemResponse> items;

}
