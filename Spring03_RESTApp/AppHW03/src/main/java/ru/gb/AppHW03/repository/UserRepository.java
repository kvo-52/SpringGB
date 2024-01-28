package ru.gb.AppHW03.repository;

import ru.gb.AppHW03.domain.User;
import ru.gb.AppHW03.mapper.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Репозиторий для работы с БД.
 */
@Component
public class UserRepository {
    /**
     * Объект подключения к БД.
     */
    private final JdbcTemplate jdbc;

    private final UserMapper userMapper;

    public UserRepository(JdbcTemplate jdbc, UserMapper userMapper) {
        this.jdbc = jdbc;
        this.userMapper = userMapper;
    }

    /**
     * Получение списка пользователей.
     * @return список пользователей.
     */
    public List<User> getUsers() {
        String sql = "select * from \"user\"";
        return jdbc.query(sql, userMapper);
    }

    /**
     * Добавление пользователя в БД.
     * @param user объект пользователя.
     */
    public void addUser(User user){
        String sql = "insert into \"user\" (name, age, email) values (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }

}
