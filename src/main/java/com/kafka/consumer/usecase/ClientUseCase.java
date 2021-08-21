package com.kafka.consumer.usecase;

import com.kafka.consumer.domain.Client;

import java.util.List;

public interface ClientUseCase {

    void execute( List<Client> clients );
}
