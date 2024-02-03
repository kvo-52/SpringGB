package ru.gb.HW05_SpringData.DTO;


import org.springframework.stereotype.Component;
import ru.gb.HW05_SpringData.Models.Task;
/**
 * Маппер преобразования объектов dto в сущности и наоборот.
 */
@Component
public class DtoMapper {
    /**
     * Преобразование в dto.
     *
     * @param task объект задачи.
     * @return объект dto.
     */
    public TaskDto toDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setDescription(task.getDescription());
        taskDto.setDateCreation(task.getDateCreation());
        taskDto.setStatus(task.getStatus());
        return taskDto;
    }

    /**
     * Преобразование в объект сущности.
     *
     * @param taskDto объект dto.
     * @return объект сущности.
     */
    public Task toEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setDescription(taskDto.getDescription());
        task.setDateCreation(taskDto.getDateCreation());
        task.setStatus(taskDto.getStatus());
        return task;
    }
}
