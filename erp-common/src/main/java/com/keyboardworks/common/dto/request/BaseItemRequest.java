package com.keyboardworks.common.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class BaseItemRequest {

    private String productCode;

    private BigDecimal quantity;
    private BigDecimal price;

}
