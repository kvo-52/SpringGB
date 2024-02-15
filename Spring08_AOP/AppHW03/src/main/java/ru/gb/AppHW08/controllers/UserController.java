package ru.gb.AppHW08.controllers;

import ru.gb.AppHW08.domain.User;
import ru.gb.AppHW08.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Контроллер пользователей.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * Сервис регистрации пользователей.
     */
    @Autowired
    private RegistrationService service;

    /**
     * Получение списка пользователей.
     * @return JSON ответ со списком пользователей.
     */
    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    /**
     * Добавление нового пользователя.
     * @param requestBody тело запроса.
     * @return подтверждение добавления пользователя.
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody Map<String, Object> requestBody) {
        String name = (String) requestBody.get("name");
        Integer age = (Integer) requestBody.get("age");
        String email = (String) requestBody.get("email");
        service.processRegistration(name, age, email);
        return "User added from body!";
    }
}
