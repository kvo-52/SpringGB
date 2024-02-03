package ru.gb.data2.Task2.exceptions;

/**
 * Исключение если объект не найден в БД.
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("User or project not found!");
    }
}
