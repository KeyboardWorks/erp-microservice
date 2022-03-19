package com.keyboardworks.erp.accounting.listener;

import com.keyboardworks.common.JsonUtil;
import com.keyboardworks.common.constant.KafkaTopic;
import com.keyboardworks.common.dto.response.inventory.GoodsReceiptResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CreateGoodsReceiptListener {

    private final JsonUtil jsonUtil;

    @KafkaListener(topics = KafkaTopic.Inventory.CREATE_GOODS_RECEIPT, containerFactory = "kafkaListenerContainerFactory")
    public void createGoodsReceipt(String goodsReceiptJson) {
        GoodsReceiptResponse response = jsonUtil.stringToObject(goodsReceiptJson, GoodsReceiptResponse.class);

        log.info("Execute Kafka Topic: {}, Goods Receipt : {}", KafkaTopic.Inventory.CREATE_GOODS_RECEIPT,
                response.getId());
    }

}
