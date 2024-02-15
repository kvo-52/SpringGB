package ru.gb.AppHW08.services;

import ru.gb.AppHW08.domain.User;

import org.springframework.stereotype.Service;

/**
 * Сервис создания пользователей.
 */
@Service
public class UserService {


     /**
     * Создание нового пользователя.
     * @param name имя пользователя.
     * @param age возраст пользователя.
     * @param email email пользователя.
     * @return созданного пользователя.
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

       return user;
    }
}
