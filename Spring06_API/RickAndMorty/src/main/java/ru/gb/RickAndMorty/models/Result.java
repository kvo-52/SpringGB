package ru.gb.RickAndMorty.models;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import java.util.List;

/**
 * Объект персонажа.
 */
@Data
public class Result {
    /**
     * Идентификатор.
     */
    private Integer id;
    /**
     * Имя.
     */
    private String name;
    /**
     * Статус.
     */
    private String status;
    /**
     * Вид.
     */
    private String species;
    /**
     * Тип.
     */
    private String type;
    /**
     * Половая принадлежность.
     */
    private String gender;
    /**
     * Ссылка на картинку.
     */
    private String image;
    /**
     * Участие в эпизодах.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> episode;
    /**
     * Ссылка на персонажа.
     */
    private String url;
    /**
     * Дата создания.
     */
    private Date created;
}
