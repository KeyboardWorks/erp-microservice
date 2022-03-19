package com.keyboardworks.erp.inventory.config;

import com.keyboardworks.common.constant.KafkaTopic;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createGoodsIssue() {
        return TopicBuilder.name(KafkaTopic.Inventory.CREATE_GOODS_ISSUE)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic createGoodsReceipt() {
        return TopicBuilder.name(KafkaTopic.Inventory.CREATE_GOODS_RECEIPT)
                .partitions(1)
                .replicas(1)
                .build();
    }

}
