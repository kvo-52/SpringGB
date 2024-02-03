package ru.gb.HW05_SpringData.Services;

import ru.gb.HW05_SpringData.Models.Status;
import ru.gb.HW05_SpringData.Models.Task;

import java.util.List;

public interface ITaskService {
    /**
     * Создание новой задачи.
     * @param task объект задачи.
     * @return созданную задачу.
     */
    public Task addTask(Task task);

    /**
     * Обновление задачи.
     *
     * @param task объект задачи.
     */
    Task updateTask(Long id, Task task);

    /**
     * Удаление задачи.
     *
     * @param id уникальный идентификатор задачи.
     */
    public void deleteTask(Long id);

    /**
     * Получение задачи.
     *
     * @param id уникальный идентификатор задачи.
     * @return объект задачи.
     */
    public Task getTask(Long id);

    /**
     * Получение всех задач.
     *
     * @return список задач.
     */
    public List<Task> getTasks();

    /**
     * Получение задач по заданному статусу.
     *
     * @param status статус задачи.
     * @return список задач с заданным статусом.
     */
    public List<Task> getTaskFormStatus(Status status);

}
