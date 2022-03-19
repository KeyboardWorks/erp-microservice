package com.keyboardworks.erp.accounting.listener;

import com.keyboardworks.common.JsonUtil;
import com.keyboardworks.common.constant.KafkaTopic;
import com.keyboardworks.common.dto.response.purchasing.PurchaseOrderResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CreatePurchaseOrderListener {

    private final JsonUtil jsonUtil;

    @KafkaListener(topics = KafkaTopic.Purchasing.CREATE_PURCHASE_ORDER, containerFactory = "kafkaListenerContainerFactory")
    public void createPurchaseOrder(String purchaseOrderJson) {
        PurchaseOrderResponse response = jsonUtil.stringToObject(purchaseOrderJson, PurchaseOrderResponse.class);

        log.info("Execute Kafka Topic: {}, Purchase Order: {}", KafkaTopic.Purchasing.CREATE_PURCHASE_ORDER,
                response.getId());
    }
}
