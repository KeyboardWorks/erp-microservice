package com.keyboardworks.erp.inventory.controller;

import com.keyboardworks.common.dto.response.inventory.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(path = "/product")
@RequiredArgsConstructor
public class ProductController {

    @GetMapping(path = "/{id}")
    public ProductResponse getProduct(@PathVariable("id") String productCode) {

        log.info("Get product with code : {}", productCode);
        ProductResponse response = new ProductResponse();
        response.setId(UUID.randomUUID().toString());
        response.setProductCode(productCode);
        response.setProductName(productCode.replace("Code", "Name"));

        return response;
    }

}
