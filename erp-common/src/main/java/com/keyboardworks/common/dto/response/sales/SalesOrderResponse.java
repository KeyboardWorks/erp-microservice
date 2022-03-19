package com.keyboardworks.common.dto.response.sales;

import com.keyboardworks.common.dto.response.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class SalesOrderResponse extends BaseResponse {

    private String salesOrderCode;
    private String customer;
    private Set<SalesOrderItemResponse> items;

}
