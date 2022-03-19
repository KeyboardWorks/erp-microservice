package com.keyboardworks.erp.sales.feign;

import com.keyboardworks.common.dto.response.inventory.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "inventory", url = "http://localhost:8083/product")
public interface InventoryProductFeign {

    @GetMapping(value = "/{id}")
    ProductResponse getProduct(@PathVariable("id") String productCode);

}
