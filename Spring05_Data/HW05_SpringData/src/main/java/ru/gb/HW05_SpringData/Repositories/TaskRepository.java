package ru.gb.HW05_SpringData.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ru.gb.HW05_SpringData.Models.Status;
import ru.gb.HW05_SpringData.Models.Task;


/**
 * Репозиторий для сущности task.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Получение списка задач по статусу задачи.
     * @param status статус задачи.
     * @return список задач.
     */
    List<Task> findByStatus(Status status);
}
