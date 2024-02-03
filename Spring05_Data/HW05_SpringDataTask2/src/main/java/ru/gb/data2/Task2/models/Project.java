package ru.gb.data2.Task2.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Сущность проекта.
 */
@Data
@Entity
@Table(name = "projects")
public class Project {
    /**
     * Идентификатор. Первичный ключ.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Имя проекта.
     */
    private String name;
    /**
     * Описание проекта.
     */
    private String description;
    /**
     * Дата создания.
     */
    private LocalDateTime createdDate;


}
