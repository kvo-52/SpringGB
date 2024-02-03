package ru.gb.HW05_SpringData.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import ru.gb.HW05_SpringData.MyException.TaskNotFoundException;
import ru.gb.HW05_SpringData.Models.Status;
import ru.gb.HW05_SpringData.Models.Task;
import ru.gb.HW05_SpringData.Repositories.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Сервис осуществляющий работу с задачами.
 */
@Service
@AllArgsConstructor
public class TaskService implements ITaskService {

    private final TaskRepository taskRepository;

    /**
     * Создание новой задачи.
     *
     * @param task объект задачи.
     * @return созданную задачу.
     */
    public Task addTask(Task task) {
        task.setStatus(Status.NOT_STARTED);
        task.setDateCreation(LocalDateTime.now());
        taskRepository.save(task);
        return task;
    }

    /**
     * Обновление задачи.
     *
     * @param task объект задачи.
     */
    public Task updateTask(Long id, Task task) {
        Task taskForUpdate = getTask(id);
        if(task.getDescription() != null) {
            taskForUpdate.setDescription(task.getDescription());
        }
        if(task.getStatus() != null) {
            taskForUpdate.setStatus(task.getStatus());
        }
        return taskRepository.save(taskForUpdate);
    }

    /**
     * Удаление задачи.
     *
     * @param id уникальный идентификатор задачи.
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    /**
     * Получение задачи.
     *
     * @param id уникальный идентификатор задачи.
     * @return объект задачи.
     */
    public Task getTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task: " + id + " not found!"));
    }

    /**
     * Получение всех задач.
     *
     * @return список задач.
     */
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    /**
     * Получение задач по заданному статусу.
     *
     * @param status статус задачи.
     * @return список задач с заданным статусом.
     */
    public List<Task> getTaskFormStatus(Status status) {
        return taskRepository.findByStatus(status);
    }
}
