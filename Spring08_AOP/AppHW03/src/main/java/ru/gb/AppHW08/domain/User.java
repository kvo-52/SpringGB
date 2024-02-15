package ru.gb.AppHW08.domain;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Сущность пользователя.
 */
@Entity
@Table(name = "user_table")
@Data
public class User {
    /**
     * Идентификатор пользователя.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Имя пользователя.
     */
    private String name;
    /**
     * Возраст пользователя.
     */
    private int age;
    /**
     * Email пользователя.
     */
    private String email;
}
