package ru.gb.hw09.PaymentApp.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Обертка для исключения.
 */
@Data
public class ExceptionBody {

    private String message;
    private LocalDateTime dateTime;
}
