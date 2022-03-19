package com.keyboardworks.common.dto.response.purchasing;

import com.keyboardworks.common.dto.response.BaseItemResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PurchaseOrderItemResponse extends BaseItemResponse {

    private String purchaseOrderCode;

}
