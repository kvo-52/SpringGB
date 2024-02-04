package ru.gb.RickAndMorty.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ru.gb.RickAndMorty.models.Characters;
import ru.gb.RickAndMorty.models.Result;
import ru.gb.RickAndMorty.models.UrlApi;

import java.util.List;

/**
 * Имплементация сервисного интерфейса.
 */
@Service
@RequiredArgsConstructor
public class ServiceApi implements IServiceApi{

    /**
     * Библиотека для создания запроса.
     */
    private final RestTemplate template;
    /**
     * Заголовок запроса.
     */
    private final HttpHeaders headers;
    /**
     * Запросы к API.
     */
    private final UrlApi urlApi;

    /**
     * Получение всех персонажей.
     * @return json ответ с метаданными и персонажами.
     */
    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> response = template.exchange(
                urlApi.getCharacterAll(),
                HttpMethod.GET,
                entity,
                Characters.class);

        return response.getBody();
    }

    public Characters getAllCharacters(String url) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> response = template.exchange(
                url,
                HttpMethod.GET,
                entity,
                Characters.class);

        return response.getBody();
    }

    /**
     * Получение конкретного персонажа.
     * @param id идентификатор персонажа.
     * @return json ответ с персонажем.
     */
    @Override
    public Result getHero(Integer id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Result> response = template.exchange(
                (urlApi.getCharacter() + id),
                HttpMethod.GET,
                entity,
                Result.class
        );

        return response.getBody();
    }
}
