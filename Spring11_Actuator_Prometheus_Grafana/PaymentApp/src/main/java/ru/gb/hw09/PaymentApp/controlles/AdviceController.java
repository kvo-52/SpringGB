package ru.gb.hw09.PaymentApp.controlles;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.gb.hw09.PaymentApp.exceptions.ExceptionBody;
import ru.gb.hw09.PaymentApp.exceptions.ExcessAmountException;
import ru.gb.hw09.PaymentApp.exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;

/**
 * Контроллер обработки исключений.
 */
@RestControllerAdvice
public class AdviceController {
    /**
     * Исключение при превышении лимита средств на счету.
     * @param e объект исключения.
     * @return обертку с собственным исключением.
     */
    @ExceptionHandler(ExcessAmountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody excessAmount(ExcessAmountException e){
        ExceptionBody exceptionBody = new ExceptionBody();
        exceptionBody.setMessage(e.getMessage());
        exceptionBody.setDateTime(LocalDateTime.now());
        return exceptionBody;
    }

    /**
     * Исключение при отсутствии заданного счета.
     * @param e объект исключения.
     * @return обертку с собственным исключением.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody resourceNotFound(ResourceNotFoundException e){
        ExceptionBody exceptionBody = new ExceptionBody();
        exceptionBody.setMessage(e.getMessage());
        exceptionBody.setDateTime(LocalDateTime.now());
        return exceptionBody;
    }
}
