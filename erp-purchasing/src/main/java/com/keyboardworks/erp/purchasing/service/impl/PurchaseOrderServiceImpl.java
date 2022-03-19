package com.keyboardworks.erp.purchasing.service.impl;

import com.keyboardworks.common.JsonUtil;
import com.keyboardworks.common.constant.KafkaTopic;
import com.keyboardworks.common.dto.request.purchasing.PurchaseOrderRequest;
import com.keyboardworks.common.dto.response.purchasing.PurchaseOrderItemResponse;
import com.keyboardworks.common.dto.response.purchasing.PurchaseOrderResponse;
import com.keyboardworks.erp.purchasing.service.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final JsonUtil jsonUtil;
    private final ModelMapper modelMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public PurchaseOrderResponse createPurchaseOrder(PurchaseOrderRequest request) {

        PurchaseOrderResponse response = modelMapper.map(request, PurchaseOrderResponse.class);

        response.setId(UUID.randomUUID().toString());
        response.setPurchaseOrderCode("Purchase Order Code : ".concat(response.getId()));
        populateProductCode(response);

        log.info("Create purchase order with id: {}", response.getId());

        sendKafka(response);

        return response;
    }

    private void populateProductCode(PurchaseOrderResponse response) {

        for (PurchaseOrderItemResponse item : response.getItems()) {
            item.setProductName(item.getProductCode().replace("Code", "Name"));
            item.setPurchaseOrderCode(response.getPurchaseOrderCode());
        }

    }

    private void sendKafka(PurchaseOrderResponse response) {
        String jsonResponse = jsonUtil.objectToString(response);
        kafkaTemplate.send(KafkaTopic.Purchasing.CREATE_PURCHASE_ORDER, jsonResponse);

        log.info("Send Topic Kafka: {}, Purchase Order: {}", KafkaTopic.Purchasing.CREATE_PURCHASE_ORDER,
                response.getId());
    }

}
