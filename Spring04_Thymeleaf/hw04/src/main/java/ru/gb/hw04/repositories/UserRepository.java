package ru.gb.hw04.repositories;

import ru.gb.hw04.model.User;
import ru.gb.hw04.utils.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для запросов к БД сущности пользователей.
 */
@Repository
@AllArgsConstructor
public class UserRepository {
    /**
     * Объект подключения к БД.
     */
    private final JdbcTemplate jdbc;

    /**
     * Объект инкапсуляции SQL запросов.
     */
    private final SqlQuery query;

    /**
     * Получение пользователя по id.
     * @param id уникальный идентификатор пользователя.
     * @return объект пользователя или null в случае его отсутствия в БД.
     */
    public User findUserById(Integer id){
        return jdbc.query(query.getFindUserById(), new Object[]{id}, new UserMapper())
                .stream().findFirst().orElse(null);
    }

    /**
     * Получение всех пользователей из БД.
     * @return список пользователей.
     */
    public List<User> findAll() {
        return jdbc.query(query.getFindAllUsers(), new UserMapper());
    }

    /**
     * Сохранение пользователя в БД.
     * @param user объект пользователя.
     * @return объект пользователя с id.
     */
    public User save(User user) {
        jdbc.update(query.getSaveUser(), user.getFirstName(), user.getLastName());
        return  user;
    }

    /**
     * Удаление пользователя из БД
     * по уникальному идентификатору.
     * @param id идентификатор пользователя.
     */
    public void deleteById(int id){
        jdbc.update(query.getDeleteUser(), id);
    }

    /**
     * Обновление пользователя в БД.
     * @param user объект пользователя с измененными данными.
     */
    public void update(User user){
        jdbc.update(query.getUpdateUser(), user.getFirstName(), user.getLastName(), user.getId());
    }
}
