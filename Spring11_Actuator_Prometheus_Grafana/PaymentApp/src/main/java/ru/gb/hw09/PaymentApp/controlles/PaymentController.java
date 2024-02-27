package ru.gb.hw09.PaymentApp.controlles;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw09.PaymentApp.models.Account;
import ru.gb.hw09.PaymentApp.models.Transaction;
import ru.gb.hw09.PaymentApp.services.PaymentService;

import java.util.List;

/**
 * Контроллер оплаты.
 */
@RestController
@AllArgsConstructor
public class PaymentController {
    /**
     * Сервис оплаты.
     */
    private final PaymentService paymentService;

    @GetMapping()
    public ResponseEntity<List<Account>> getAccounts(){
        return ResponseEntity.ok().body(paymentService.getAllAccounts());
    }

    /**
     * Проведение оплаты.
     * @param transaction объект с данными для транзакции.
     * @return ответ с подтверждением.
     */
    @PostMapping()
    public ResponseEntity<Void> transaction(@RequestBody Transaction transaction){
        paymentService.transaction(transaction);
        return ResponseEntity.ok().body(null);
    }

    /**
     * Откат произведенной транзакции.
     * @param transaction объект с данными для транзакции.
     * @return ответ с подтверждением.
     */
    @PostMapping("/rollback")
    public ResponseEntity<Void> rollbackTransaction(@RequestBody Transaction transaction){
        paymentService.rollbackTransaction(transaction);
        return ResponseEntity.ok().body(null);
    }
}
