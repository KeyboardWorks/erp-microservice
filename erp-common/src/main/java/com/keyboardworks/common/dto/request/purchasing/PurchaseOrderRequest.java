package com.keyboardworks.common.dto.request.purchasing;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class PurchaseOrderRequest {

    private String supplier;
    private Set<PurchaseOrderItemRequest> items;

}
