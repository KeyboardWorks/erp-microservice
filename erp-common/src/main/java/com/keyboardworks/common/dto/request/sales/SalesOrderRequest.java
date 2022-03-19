package com.keyboardworks.common.dto.request.sales;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class SalesOrderRequest {

    private String customer;
    private Set<SalesOrderItemRequest> items;

}
