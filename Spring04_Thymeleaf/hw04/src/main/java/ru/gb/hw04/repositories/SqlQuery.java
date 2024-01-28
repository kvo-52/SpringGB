package ru.gb.hw04.repositories;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Объект инкапсулирующий sql запросы к БД.
 * Получает запросы из application.properties
 */
@Component
@ConfigurationProperties("sql.query")
@Data
public class SqlQuery {
    /**
     * Получение пользователя по id.
     */
    private String findUserById;
    /**
     * Получение всех пользователей.
     */
    private String findAllUsers;
    /**
     * Сохранение пользователя.
     */
    private String saveUser;
    /**
     * Удаление пользователя.
     */
    private String deleteUser;
    /**
     * Обновление пользователя.
     */
    private String updateUser;
}
