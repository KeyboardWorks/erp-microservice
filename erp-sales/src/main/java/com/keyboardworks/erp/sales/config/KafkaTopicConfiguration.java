package com.keyboardworks.erp.sales.config;

import com.keyboardworks.common.constant.KafkaTopic;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic createSalesOrder() {
        return TopicBuilder.name(KafkaTopic.Sales.CREATE_SALES_ORDER)
                .partitions(1)
                .replicas(1)
                .build();
    }

}
