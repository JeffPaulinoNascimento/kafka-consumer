package com.kafka.consumer.external.kafka.impl;

import com.kafka.consumer.domain.Client;
import com.kafka.consumer.external.kafka.BaseClientConsumer;
import com.kafka.consumer.usecase.ClientUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BaseClientConsumerImpl implements BaseClientConsumer {

    private final ClientUseCase clientUseCase;

    @Override
    @KafkaListener(
            topics = "${spring.kafka.topic-client-consumer}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumerTopic(
            @Payload Client message,
            @Header( KafkaHeaders.RECEIVED_PARTITION_ID ) int partition ) {

        log.info( "mensagem consumida com sucesso " );

        clientUseCase.execute( message );

    }
}
