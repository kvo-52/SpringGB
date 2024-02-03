package ru.gb.data2.Task2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.data2.Task2.models.UsersProject;

import java.util.List;

/**
 * Репозиторий пользователей проекта.
 */
@Repository
public interface UserProjectRepository extends JpaRepository<UsersProject, Long> {
    /**
     * Получение по идентификатору проекта.
     * @param projectId идентификатор проекта.
     * @return список пользователей проекта.
     */
    List<UsersProject> findByProjectId(Long projectId);

    /**
     * Получение по идентификатору пользователя.
     * @param userId идентификатор пользователя.
     * @return список пользователей проекта.
     */
    List<UsersProject> findByUserId(Long userId);

    /**
     * Удаление пользователей проекта по идентификаторам.
     * @param userId идентификатор пользователя.
     * @param projectId идентификатор проекта.
     */
    void deleteByUserIdAndProjectId(Long userId, Long projectId);

}
