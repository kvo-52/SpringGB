package ru.gb.data2.Task2.exceptions;

/**
 * Исключение - пользователь уже участвует в проекте.
 */
public class UserAlreadyInProjectException extends RuntimeException{
    public UserAlreadyInProjectException(String message) {
        super(message);
    }
}
