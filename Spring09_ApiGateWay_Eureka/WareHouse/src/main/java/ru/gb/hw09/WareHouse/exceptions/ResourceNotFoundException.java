package ru.gb.hw09.WareHouse.exceptions;

/**
 * Товар не найден.
 */
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
