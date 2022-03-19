package com.keyboardworks.erp.sales.service.impl;

import com.keyboardworks.common.JsonUtil;
import com.keyboardworks.common.constant.KafkaTopic;
import com.keyboardworks.common.dto.request.sales.SalesOrderRequest;
import com.keyboardworks.common.dto.response.inventory.ProductResponse;
import com.keyboardworks.common.dto.response.sales.SalesOrderItemResponse;
import com.keyboardworks.common.dto.response.sales.SalesOrderResponse;
import com.keyboardworks.erp.sales.feign.InventoryProductFeign;
import com.keyboardworks.erp.sales.service.SalesOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class SalesOrderServiceImpl implements SalesOrderService {

    private final JsonUtil jsonUtil;
    private final ModelMapper modelMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final InventoryProductFeign inventoryProductFeign;

    @Override
    public SalesOrderResponse createSalesOrder(SalesOrderRequest request) {

        SalesOrderResponse response = modelMapper.map(request, SalesOrderResponse.class);

        response.setId(UUID.randomUUID().toString());
        response.setSalesOrderCode("Sales Order Code : ".concat(response.getId()));
        populateProductCode(response);

        log.info("Create sales order with id: {}", response.getId());

        sendKafka(response);

        return response;
    }

    private void populateProductCode(SalesOrderResponse response) {

        for (SalesOrderItemResponse item : response.getItems()) {
            ProductResponse productResponse = inventoryProductFeign.getProduct(item.getProductCode());

            item.setProductName(productResponse.getProductName());
            item.setSalesOrderCode(response.getSalesOrderCode());
        }

    }

    private void sendKafka(SalesOrderResponse response) {
        String jsonResponse = jsonUtil.objectToString(response);
        kafkaTemplate.send(KafkaTopic.Sales.CREATE_SALES_ORDER, jsonResponse);

        log.info("Send Topic Kafka: {}, Sales Order: {}", KafkaTopic.Sales.CREATE_SALES_ORDER,
                response.getId());
    }

}
