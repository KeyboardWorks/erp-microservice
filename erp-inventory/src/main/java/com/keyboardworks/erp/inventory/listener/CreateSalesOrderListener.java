package com.keyboardworks.erp.inventory.listener;

import com.keyboardworks.common.JsonUtil;
import com.keyboardworks.common.constant.KafkaTopic;
import com.keyboardworks.common.dto.response.sales.SalesOrderResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CreateSalesOrderListener {

    private final JsonUtil jsonUtil;

    @KafkaListener(topics = KafkaTopic.Sales.CREATE_SALES_ORDER, containerFactory = "kafkaListenerContainerFactory")
    public void createSalesOrder(String salesOrderJson) {
        SalesOrderResponse response = jsonUtil.stringToObject(salesOrderJson, SalesOrderResponse.class);

        log.info("Execute Kafka Topic: {}, Sales Order: {}", KafkaTopic.Sales.CREATE_SALES_ORDER,
                response.getId());
    }

}
