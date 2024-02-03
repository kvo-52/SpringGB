package ru.gb.data2.Task2.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.gb.data2.Task2.models.Project;
import ru.gb.data2.Task2.models.User;
import ru.gb.data2.Task2.services.UserProjectService;

import java.util.List;

/**
 * Контроллер приложения.
 */
@RestController
@AllArgsConstructor
public class UserProjectController {
    /**
     * Объект сервиса приложения.
     */
    private final UserProjectService service;

    /**
     * Список пользователей связанных с проектом.
     * @param id идентификатор проекта.
     * @return список пользователей.
     */
    @GetMapping("/project/{project_id}")
    @Operation(summary = "Список пользователей связанных с проектом")
    public ResponseEntity<List<User>> getUsersByProjectId(
            @PathVariable("project_id") Long id){
        return ResponseEntity.ok().body(service.getUsersByProjectId(id));
    }

    /**
     * Список проектов связанный с пользователем.
     * @param id идентификатор пользователя.
     * @return список проектов.
     */
    @GetMapping("/user/{user_id}")
    @Operation(summary = "Список проектов связанный с пользователем")
    public ResponseEntity<List<Project>> getProjectsByUserId(
            @PathVariable("user_id") Long id){
        return ResponseEntity.ok().body(service.getProjectsByUserId(id));
    }

    /**
     * Добавление пользователя в проект.
     * @param userId идентификатор пользователя.
     * @param projectId идентификатор проекта.
     * @return подтверждение операции.
     */
    @PostMapping("/add/{user_id}/{project_id}")
    @Operation(summary = "Добавление пользователя в проект")
    public ResponseEntity<String> addUserToProject(
            @PathVariable("user_id") Long userId,
            @PathVariable("project_id") Long projectId){
        service.addUserToProject(userId, projectId);
        return ResponseEntity.ok().body("User added.");
    }

    /**
     * Удаление пользователя из проекта.
     * @param userId идентификатор пользователя.
     * @param projectId идентификатор проекта.
     * @return подтверждение операции.
     */
    @PostMapping("/remove/{user_id}/{project_id}")
    @Operation(summary = "Удаление пользователя из проекта")
    public ResponseEntity<String> removeUserFromProject(
            @PathVariable("user_id") Long userId,
            @PathVariable("project_id") Long projectId) {
        service.removeUserFromProject(userId, projectId);
        return ResponseEntity.ok().body("User removed.");
    }
}
