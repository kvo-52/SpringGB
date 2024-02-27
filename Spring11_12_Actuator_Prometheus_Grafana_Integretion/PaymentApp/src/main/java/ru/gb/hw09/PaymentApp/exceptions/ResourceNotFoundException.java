package ru.gb.hw09.PaymentApp.exceptions;

/**
 * Отсутствие переданного счета.
 */
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
