package com.kafka.consumer.usecase.impl;

import com.kafka.consumer.domain.Client;
import com.kafka.consumer.usecase.ClientUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientUseCaseImpl implements ClientUseCase {

    @Override
    public void execute( Client client ) {
        log.info( "Cliente recebidos via menssageria: {} ", client );
    }

}
