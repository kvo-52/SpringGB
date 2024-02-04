package ru.gb.RickAndMorty.models;

import lombok.Data;

/**
 * Сущность с информацией для пагинации.
 */
@Data
public class Info {
    /**
     * Количество записей.
     */
    private Integer count;
    /**
     * Количество страниц.
     */
    private Integer pages;
    /**
     * Ссылка на следующую страницу.
     */
    private String next;
    /**
     * Ссылка на предыдущую страницу.
     */
    private String prev;
}
