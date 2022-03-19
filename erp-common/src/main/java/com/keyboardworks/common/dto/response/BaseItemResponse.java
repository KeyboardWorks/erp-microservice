package com.keyboardworks.common.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BaseItemResponse {

    private String productCode;
    private String productName;

    private BigDecimal quantity;
    private BigDecimal price;

}
