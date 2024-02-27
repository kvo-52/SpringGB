package ru.gb.hw09.PaymentApp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.hw09.PaymentApp.models.Account;
import ru.gb.hw09.PaymentApp.models.Transaction;
import ru.gb.hw09.PaymentApp.exceptions.ExcessAmountException;
import ru.gb.hw09.PaymentApp.repositories.PaymentRepository;

import java.util.List;

/**
 * Сервис для работы со счетами.
 */
@Service
@AllArgsConstructor
public class PaymentService {
    /**
     * Репозиторий для работы со счетами.
     */
    private final PaymentRepository paymentRepository;

    /**
     * Проведение транзакции со счетами.
     * @param transaction объект с данными для транзакции.
     */
    @Transactional
    public void transaction(Transaction transaction) {
        Account creditAccount = paymentRepository.findByNumber(transaction.getCreditNumber());
        if((creditAccount.getBalance().compareTo(transaction.getSum())) < 0) {
            throw new ExcessAmountException("Не достаточно средств!");
        }

        Account debitAccount = paymentRepository.findByNumber(transaction.getDebitNumber());

        creditAccount.setBalance(
                creditAccount.getBalance().subtract(transaction.getSum()));
        debitAccount.setBalance(
                debitAccount.getBalance().add(transaction.getSum()));

        paymentRepository.save(creditAccount);
        paymentRepository.save(debitAccount);
    }

    /**
     * Откат произведенной транзакции.
     * @param transaction объект с данными для транзакции.
     */
    @Transactional
    public void rollbackTransaction(Transaction transaction) {
        Account debitAccount = paymentRepository.findByNumber(transaction.getDebitNumber());
        Account creditAccount = paymentRepository.findByNumber(transaction.getCreditNumber());

        debitAccount.setBalance(
                debitAccount.getBalance().subtract(transaction.getSum()));
        creditAccount.setBalance(
                creditAccount.getBalance().add(transaction.getSum()));

        paymentRepository.save(creditAccount);
        paymentRepository.save(debitAccount);
    }

    /**
     * Получение всех аккаунтов.
     * @return список аккаунтов.
     */
    public List<Account> getAllAccounts() {
        return paymentRepository.findAll();
    }
}
