package ru.gb.WebClient.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gb.WebClient.models.Transaction;

/**
 * Клиент для обращения к api payment
 */

@FeignClient(name = "payment")
public interface PaymentClientApi {

    @PostMapping()
    ResponseEntity<?> pay(@RequestBody Transaction transaction);

    @PostMapping("/rollback")
    void rollbackPay(@RequestBody Transaction transaction);

}
