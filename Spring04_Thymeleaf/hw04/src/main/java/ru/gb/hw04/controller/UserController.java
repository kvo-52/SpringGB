package ru.gb.hw04.controller;

import ru.gb.hw04.model.User;
import ru.gb.hw04.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Контроллер пользователей.
 */
@Controller
@AllArgsConstructor
@Log
public class UserController {
    /**
     * Объект сервиса для работы с пользователями.
     */
    private final UserService userService;

    /**
     * Получение всех пользователей.
     * @param model модель для передачи данных в представление.
     * @return представление со списком пользователей.
     */
    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        log.info(getDateTime() + "Запрошен список пользователей");
        return "user-list";
    }

    /**
     * Создание нового пользователя.
     * @param user объект пользователя.
     * @return представление для создания пользователя.
     */
    @GetMapping("/user-create")
    public String createUserForm(User user){
        log.info(getDateTime() + "Запрос на создание нового пользователя");
        return "user-create";
    }

    /**
     * Получение данных о новом пользователе с формы представления.
     * @param user объект пользователя с заполненными полями (валидация не проводится).
     * @return перенаправление на страницу со списком пользователей.
     */
    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        log.info(getDateTime() + "Новый пользователь "
                + user.getId() + " создан.");
        return "redirect:/users";
    }

    /**
     * Удаление пользователя.
     * @param id уникальный идентификатор пользователя.
     * @return перенаправление на страницу со списком пользователей.
     */
    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteById(id);
        log.warning(getDateTime() + "Пользователь "
                + id + " удален!");
        return "redirect:/users";
    }

    /**
     * Изменение данных пользователя.
     * @param id уникальный идентификатор пользователя.
     * @param model модель для передачи данных в представление.
     * @return представление для изменения данных.
     */
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Integer id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        log.info(getDateTime()
                + "Получен запрос на изменение пользователя " + id);
        return "user-update";
    }

    /**
     * Получение данных об измененном пользователя с формы представления.
     * @return перенаправление на страницу со списком пользователей.
     */
    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        log.info(getDateTime() + "Пользователь " + user.getId() + " изменен");
        return "redirect:/users";
    }

    /**
     * Служебный метод получения текущих даты и времени.
     * @return текущая дата и время в отформатированном виде.
     */
    private String getDateTime(){
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + ": ";
    }
}

