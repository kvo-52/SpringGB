package ru.gb.hw07Security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер приложения.
 */
@Controller
public class AppController {
    /**
     * Домашняя страница.
     * @return представление домашней страницы.
     */
    @GetMapping("/")
    public String home(){
        return "home";
    }

    /**
     * Страница для пользователей с ролью USER.
     * @return публичное представление.
     */
    @GetMapping("/public")
    public String userPage(){
        return "public";
    }

    /**
     * Страница для пользователей с ролью ADMIN.
     * @return закрытое представление.
     */
    @GetMapping("/private")
    public String adminPage(){
        return "private";
    }

    /**
     * Страница отказа в доступе.
     * @return представление отказа в доступе.
     */
    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }

    /**
     * Аутентификация пользователя.
     * @return представление аутентификации.
     */
    @GetMapping("/login")
    public String auth(){
        return "login";
    }
}
