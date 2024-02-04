package ru.gb.RickAndMorty.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.RickAndMorty.models.Characters;
import ru.gb.RickAndMorty.services.ServiceApi;

@Controller
@AllArgsConstructor
public class ControllerApiRickAndMorty {
    /**
     * Сервис для работы с API.
     */
    private final ServiceApi serviceApi;

    /**
     * Получение списка героев.
     * @param url ссылка для перехода на следующую страницу.
     * @param model модель для передачи данных.
     * @return представление с героями.
     */
    @GetMapping("/")
    public String getAllHeroes(
            @RequestParam(value = "url", required = false)
            String url, Model model){
        Characters characters;
        if (url != null){
            characters = serviceApi.getAllCharacters(url);
        }else{
            characters = serviceApi.getAllCharacters();
        }
        model.addAttribute("heroes", characters.getResults());
        model.addAttribute("next", characters.getInfo().getNext());
        model.addAttribute("prev", characters.getInfo().getPrev());
        return "heroes";
    }

    /**
     * Получение конкретного героя.
     * @param id идентификатор героя.
     * @param model объект для передачи данных в представление.
     * @return представление с конкретным героем.
     */
    @GetMapping("/{id}")
    public String getHero(@PathVariable Integer id, Model model){
        model.addAttribute("hero", serviceApi.getHero(id));
        return "hero";
    }
}
