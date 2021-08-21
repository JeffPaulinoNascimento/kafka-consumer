package com.kafka.consumer.usecase.impl;

import com.kafka.consumer.domain.Client;
import com.kafka.consumer.usecase.ClientUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientUseCaseImpl implements ClientUseCase {

    @Override
    public void execute( List<Client> clients ) {
        log.info( "Clientes recebidos via menssageria: {} ", clients );
    }

}
