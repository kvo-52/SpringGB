package ru.gb.hw09.PaymentApp.exceptions;

/**
 * Превышение остатка на счету.
 */
public class ExcessAmountException extends RuntimeException {
    public ExcessAmountException(String message) {
        super(message);
    }
}
