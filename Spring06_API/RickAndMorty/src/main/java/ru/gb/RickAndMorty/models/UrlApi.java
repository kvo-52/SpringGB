package ru.gb.RickAndMorty.models;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Инкапсулированные запросы с api.
 */
@Data
@Component
@ConfigurationProperties("url.api")
public class UrlApi {
    /**
     * Получение всех персонажей.
     */
    private String characterAll;
    /**
     * Получение конкретного персонажа.
     */
    private String character;
}
