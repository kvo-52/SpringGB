package ru.gb.HW05_SpringData.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Сущность задачи.
 */
@Data
@Entity
@Table(name = "tasks")
public class Task {

    /**
     * Уникальный идентификатор задачи.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Описание задачи.
     */
    private String description;
    /**
     * Время создания задачи.
     */
    private LocalDateTime dateCreation;
    /**
     * Статус задачи.
     */
    @Enumerated(EnumType.STRING)
    private Status status;

}
