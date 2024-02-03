package ru.gb.data2.Task2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Пользователи проекта.
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "entity_with_relation")
public class UsersProject extends EntityWithRelation{
    /**
     * Идентификатор проекта.
     */
    @Column(name = "project_id")
    private Long projectId;
    /**
     * Идентификатор пользователя.
     */
    @Column(name = "user_id")
    private Long userId;
}
