package ru.gb.data2.Task2.controllers;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.gb.data2.Task2.exceptions.BodyException;
import ru.gb.data2.Task2.exceptions.ResourceNotFoundException;
import ru.gb.data2.Task2.exceptions.UserAlreadyInProjectException;

/**
 * Контроллер перехватывающий исключения и уведомляющий фронт.
 */
@RestControllerAdvice
@Log
public class AdviceController {
    /**
     * Ответ при генерации исключения UserAlreadyInProjectException.
     * @param e объект исключения.
     * @return сообщение об исключении.
     */
    @ExceptionHandler(UserAlreadyInProjectException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BodyException userInProjectException(UserAlreadyInProjectException e){
        log.warning(e.getMessage());
        return new BodyException(e.getMessage());
    }

    /**
     * Ответ при отсутствии объекта в БД.
     * @param e объект исключения.
     * @return сообщение об исключении.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BodyException resourceNotFound(ResourceNotFoundException e){
        log.warning(e.getMessage());
        return new BodyException(e.getMessage());
    }
}
