package com.keyboardworks.common.dto.response.inventory;

import com.keyboardworks.common.dto.response.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseInventoryResponse extends BaseResponse {

    private String warehouseCode;

}
