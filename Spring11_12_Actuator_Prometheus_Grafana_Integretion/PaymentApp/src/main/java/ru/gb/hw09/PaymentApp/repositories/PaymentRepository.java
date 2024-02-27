package ru.gb.hw09.PaymentApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.hw09.PaymentApp.models.Account;

/**
 * Репозиторий для работы со счетами.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Account, Long> {

    Account findByNumber(Long number);

}
