package com.keyboardworks.common.dto.response.inventory;

import com.keyboardworks.common.dto.response.BaseItemResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class BaseInventoryItemResponse {

    private String productCode;
    private String productName;

    private BigDecimal quantity;

    private String gridCode;
    private String containerCode;

}
