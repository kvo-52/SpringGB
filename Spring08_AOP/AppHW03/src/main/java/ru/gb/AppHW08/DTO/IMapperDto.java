package ru.gb.AppHW08.DTO;

import ru.gb.AppHW08.domain.User;

/**
 * Интерфейс преобразование объектов dao в сущности и наоборот.
 */
public interface IMapperDto {
    /**
     * Преобразование dto в сущность.
     * @param userDTO объект dao.
     * @return сущность user.
     */
    User toEntity(UserDTO userDTO);

    /**
     * Преобразование сущности в dto.
     * @param user сущность пользователя.
     * @return объект dto.
     */
    UserDTO toDto(User user);
}
