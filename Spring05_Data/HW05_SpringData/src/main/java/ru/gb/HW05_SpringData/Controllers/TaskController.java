package ru.gb.HW05_SpringData.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ru.gb.HW05_SpringData.DTO.DtoMapper;
import ru.gb.HW05_SpringData.DTO.TaskDto;
import ru.gb.HW05_SpringData.Models.Status;
import ru.gb.HW05_SpringData.Models.Task;
import ru.gb.HW05_SpringData.Services.ITaskService;

import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {
    /**
     * Сервис для работы с объектами задач.
     */
    private final ITaskService taskService;

    /**
     * Объект преобразующий dto в сущности и наоборот.
     */
    private final DtoMapper dtoMapper;

    /**
     * Эндпоинт получения конкретной задачи.
     *
     * @param id    идентификатор задачи.
     * @return страницу конкретной задачи.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(dtoMapper.toDto(taskService.getTask(id)));
    }

    /**
     * Эндпоинт добавления новой задачи.
     *
     * @param newTask       объект новой задачи с заполненными полями.
     * @param bindingResult объект хранящий результат валидации.
     * @return при успешной валидации перенаправление на домашнюю страницу,
     * иначе страница создания задачи с выявленными ошибками.
     */
    @PostMapping("/add")
    public ResponseEntity<TaskDto> addTask(@RequestBody @Validated TaskDto newTask,
                                           BindingResult bindingResult) {
        Task addedTask = taskService.addTask(dtoMapper.toEntity(newTask));
        return ResponseEntity.ok().body(dtoMapper.toDto(addedTask));
    }

    /**
     * Эндпоинт получения всех задач.
     * @return список задач.
     */
    @GetMapping("/")
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        List<TaskDto> tasks = taskService.getTasks()
                .stream().map(dtoMapper::toDto).toList();
        return ResponseEntity.ok().body(tasks);
    }

    /**
     * Эндпоинт получения задач по заданному статусу.
     * @param status статус задачи.
     * @return список найденных задач.
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<TaskDto>> getTasksByStatus(
            @PathVariable("status") Status status){
        List<TaskDto> tasks = taskService.getTaskFormStatus(status)
                .stream().map(dtoMapper::toDto).toList();
        return ResponseEntity.ok().body(tasks);
    }

    /**
     * Эндпоинт обновления существующей задачи.
     *
     * @param id    идентификатор задачи.
     * @return страницу для обновления задачи.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("id") Long id, @RequestBody TaskDto task) {
        Task updateTask = taskService.updateTask(id, dtoMapper.toEntity(task));
        return ResponseEntity.ok().body(dtoMapper.toDto(updateTask));
    }

    /**
     * Эндпоинт удаления задачи.
     *
     * @param id идентификатор задачи.
     * @return перенаправление на домашнюю страницу.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().body("Task " + id + " deleted!");
    }
}
