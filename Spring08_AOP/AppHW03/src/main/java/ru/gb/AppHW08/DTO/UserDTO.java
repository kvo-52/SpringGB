package ru.gb.AppHW08.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(description = "UserDto")
@Data
public class UserDTO {

    @Schema(description = "Имя пользователя", example = "Kat")
    @Size(min = 2, max = 50,
            message = "Имя должно быть более 2 символов и менее 50 символов!")
    @Pattern(regexp = "[a-zA-Zа-яА-Я]+", message = "Имя должно состоять из букв!")
    private String name;
    @Schema(description = "Возраст пользователя", example = "25")
    @NotNull
    @Min(value = 1, message = "Возраст не может быть меньше 1 года!")
    @Max(value = 120, message = "Возраст не может быть больше 120!")
    private int age;

    @Schema(description = "email пользователя", example = "kat@mgail.com")
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-z]+",
            message = "Формат email должен быть kat@mgail.com")
    private String email;

}
