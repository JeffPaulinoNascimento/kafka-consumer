package com.kafka.consumer.usecase;

import com.kafka.consumer.domain.Client;

public interface ClientUseCase {

    void execute( Client clients );
}
