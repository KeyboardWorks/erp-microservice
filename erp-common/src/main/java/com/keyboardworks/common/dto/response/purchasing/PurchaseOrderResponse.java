package com.keyboardworks.common.dto.response.purchasing;

import com.keyboardworks.common.dto.response.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class PurchaseOrderResponse extends BaseResponse {

    private String purchaseOrderCode;
    private String supplier;
    private Set<PurchaseOrderItemResponse> items;

}
