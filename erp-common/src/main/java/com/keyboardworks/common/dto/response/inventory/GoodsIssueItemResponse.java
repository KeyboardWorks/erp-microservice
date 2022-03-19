package com.keyboardworks.common.dto.response.inventory;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GoodsIssueItemResponse extends BaseInventoryItemResponse {

    private String goodsIssueCode;

}
