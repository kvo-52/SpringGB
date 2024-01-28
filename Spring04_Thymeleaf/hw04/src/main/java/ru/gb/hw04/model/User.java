package ru.gb.hw04.model;

import lombok.Data;

import java.util.Objects;

/**
 * Сущность пользователя.
 */
@Data
public class User {
    /**
     * Уникальный идентификатор.
     */
    private int id;
    /**
     * Имя пользователя.
     */
    private String firstName;
    /**
     * Фамилия пользователя.
     */
    private String lastName;

}
