package ru.gb.WebClient.controllers;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.gb.WebClient.seriveces.BasketServices;

/**
 * Контроллер магазина.
 */

@Controller
@AllArgsConstructor
public class ShopController {
    /**
     * Объект скрывающий сложную логику. Паттерн Фасад.
     */
    private final BasketServices basketServices;

    /**
     * Домашняя страница.
     * @param model модель для передачи данных представлению.
     * @return домашнюю страницу.
     */
    @Timed("getProductTime")
    @GetMapping("/")
    public String homePage(Model model,
                           @RequestParam(value = "confirm", required = false) String confirm){
        model.addAttribute("products", basketServices.getProducts());
        if (confirm != null){
            model.addAttribute("confirm", confirm);
        }
        return "home";
    }

    /**
     * Покупка продукта.
     * @param id идентификатор товара.
     * @param amount количество товара.
     * @return перенаправление на домашнюю страницу.
     */
    @Timed("ProductByTime")
    @PostMapping("/buy/{id}")
    public String buyProduct(@PathVariable("id") Long id,
                             @RequestParam("amount") Integer amount,
                             RedirectAttributes redirectAttributes){
        basketServices.buyProduct(id, amount);
        redirectAttributes.addAttribute("confirm", "Покупка успешно совершена!");
        return "redirect:/";
    }

    /**
     * Страница с ошибками в ходе покупки товара.
     * @param e объект исключения.
     * @param model модель для передачи данных представлению.
     * @return страницу с ошибками.
     */
    @ExceptionHandler(RuntimeException.class)
    public String errorPage(RuntimeException e, Model model){
        model.addAttribute("message", e.getMessage());
        model.addAttribute("products", basketServices.getProducts());
        return "home";
    }
}
