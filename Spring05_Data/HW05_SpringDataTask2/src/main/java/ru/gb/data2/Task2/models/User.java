package ru.gb.data2.Task2.models;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Сущность пользователя.
 */
@Data
@Entity
@Table(name = "users")
public class User {
    /**
     * Идентификатор. Первичный ключ.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Имя пользователя.
     */
    private String username;
    /**
     * Пароль пользователя.
     */
    private String password;
    /**
     * Email пользователя.
     */
    private String email;
    /**
     * Роль пользователя.
     */
    private String role;

}
