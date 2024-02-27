package ru.gb.WebClient.config;

import lombok.RequiredArgsConstructor;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import ru.gb.WebClient.interfaces.PaymentClientApi;
import ru.gb.WebClient.interfaces.StorageClientApi;
import ru.gb.WebClient.seriveces.ShopService;

/**
 * Класс конфигурации тестирования.
 */
@TestConfiguration
@RequiredArgsConstructor
public class TestConfig {

    @Bean
    @Primary
    public PaymentClientApi paymentClientApi(){
        return Mockito.mock(PaymentClientApi.class);
    }

    @Bean
    @Primary
    public StorageClientApi storageClientApi(){
        return Mockito.mock(StorageClientApi.class);
    }

    @Bean
    @Primary
    public ShopService shopService(){
        return new ShopService(paymentClientApi(), storageClientApi(), "2");
    }
}
