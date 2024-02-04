package ru.gb.RickAndMorty.services;

import ru.gb.RickAndMorty.models.Characters;
import ru.gb.RickAndMorty.models.Result;

/**
 * Интерфейс сервиса запросов к api.
 */
public interface IServiceApi {
    /**
     * Получение всех персонажей.
     * @return данные о персонажах и метаданные.
     */
    Characters getAllCharacters();

    Characters getAllCharacters(String url);

    /**
     * Получение конкретного персонажа.
     * @param id идентификатор персонажа.
     * @return объект персонажа.
     */
    Result getHero(Integer id);
}
