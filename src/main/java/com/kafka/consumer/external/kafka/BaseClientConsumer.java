package com.kafka.consumer.external.kafka;

import com.kafka.consumer.domain.Client;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;

public interface BaseClientConsumer {
    void consumerTopic(@Payload List<Client> message, @Header( KafkaHeaders.RECEIVED_PARTITION_ID ) int partition);
}
