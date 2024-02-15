package ru.gb.AppHW08.repository;


import ru.gb.AppHW08.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Репозиторий для работы с БД.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
