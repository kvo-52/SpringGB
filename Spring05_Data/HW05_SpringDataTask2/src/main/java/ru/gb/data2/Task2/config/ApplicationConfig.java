package ru.gb.data2.Task2.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный класс приложения.
 */
@Configuration
public class ApplicationConfig {
    /**
     * Бин конфигурации документации Swagger.
     * @return бин конфигурации.
     */
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(
                new Info().title("Приложение по управлению проектом")
                        .description("Позволяет отслеживать сотрудников назначенных на проекты, изменять состав сотрудников")
                        .version("0.001"));
    }

}
