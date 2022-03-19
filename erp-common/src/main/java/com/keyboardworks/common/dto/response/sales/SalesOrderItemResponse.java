package com.keyboardworks.common.dto.response.sales;

import com.keyboardworks.common.dto.response.BaseItemResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SalesOrderItemResponse extends BaseItemResponse {

    private String salesOrderCode;

}
