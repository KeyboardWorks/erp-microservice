package com.keyboardworks.erp.inventory.service.impl;

import com.keyboardworks.common.JsonUtil;
import com.keyboardworks.common.constant.KafkaTopic;
import com.keyboardworks.common.dto.response.inventory.GoodsReceiptItemResponse;
import com.keyboardworks.common.dto.response.inventory.GoodsReceiptResponse;
import com.keyboardworks.common.dto.response.purchasing.PurchaseOrderResponse;
import com.keyboardworks.erp.inventory.service.GoodsReceiptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoodsReceiptServiceImpl implements GoodsReceiptService {

    private final JsonUtil jsonUtil;
    private final ModelMapper modelMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public GoodsReceiptResponse createGoodsReceipt(PurchaseOrderResponse request) {

        GoodsReceiptResponse response = modelMapper.map(request, GoodsReceiptResponse.class);

        response.setId(UUID.randomUUID().toString());
        response.setGoodsReceiptCode("Goods Receipt Code : ".concat(response.getId()));
        response.setWarehouseCode("warehouseCode-goodsReceipt");

        for(GoodsReceiptItemResponse item : response.getItems()) {
            item.setGoodsReceiptCode(response.getGoodsReceiptCode());
        }

        log.info("Create goods receipt with id: {}", response.getId());

        sendKafka(response);

        return response;
    }

    private void sendKafka(GoodsReceiptResponse response) {
        String jsonResponse = jsonUtil.objectToString(response);
        kafkaTemplate.send(KafkaTopic.Inventory.CREATE_GOODS_RECEIPT, jsonResponse);

        log.info("Send Topic Kafka: {}, Goods Receipt: {}", KafkaTopic.Inventory.CREATE_GOODS_RECEIPT,
                response.getId());
    }
}
