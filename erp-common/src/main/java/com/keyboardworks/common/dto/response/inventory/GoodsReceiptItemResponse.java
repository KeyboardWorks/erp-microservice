package com.keyboardworks.common.dto.response.inventory;

import com.keyboardworks.common.dto.response.BaseItemResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GoodsReceiptItemResponse extends BaseItemResponse {

    private String goodsReceiptCode;

}
