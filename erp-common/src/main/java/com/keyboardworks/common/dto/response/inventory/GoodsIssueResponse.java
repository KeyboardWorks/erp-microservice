package com.keyboardworks.common.dto.response.inventory;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class GoodsIssueResponse extends BaseInventoryResponse {

    private String goodsIssueCode;
    private Set<GoodsIssueItemResponse> items;

}
