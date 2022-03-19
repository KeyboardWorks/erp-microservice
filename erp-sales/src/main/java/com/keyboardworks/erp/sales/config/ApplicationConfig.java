package com.keyboardworks.erp.sales.config;

import com.keyboardworks.common.config.CommonConfiguration;
import com.keyboardworks.common.config.KafkaConsumerConfig;
import com.keyboardworks.common.config.KafkaProducerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CommonConfiguration.class, KafkaProducerConfig.class, KafkaConsumerConfig.class})
public class ApplicationConfig {
}
