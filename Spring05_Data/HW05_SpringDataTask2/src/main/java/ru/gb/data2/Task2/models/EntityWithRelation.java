package ru.gb.data2.Task2.models;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Связующая сущность.
 */
@MappedSuperclass
@Data
public abstract class EntityWithRelation {
    /**
     * Идентификатор. Первичный ключ.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Данное поле не использовал.
    private Long relatedEntityId;
}
