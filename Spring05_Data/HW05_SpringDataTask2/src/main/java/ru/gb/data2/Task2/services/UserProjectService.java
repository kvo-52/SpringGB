package ru.gb.data2.Task2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import ru.gb.data2.Task2.exceptions.ResourceNotFoundException;
import ru.gb.data2.Task2.exceptions.UserAlreadyInProjectException;
import ru.gb.data2.Task2.models.Project;
import ru.gb.data2.Task2.models.User;
import ru.gb.data2.Task2.models.UsersProject;
import ru.gb.data2.Task2.repositories.ProjectRepository;
import ru.gb.data2.Task2.repositories.UserProjectRepository;
import ru.gb.data2.Task2.repositories.UserRepository;



/**
 * Сервисный класс для работы с приложением.
 */
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserProjectService {

    /**
     * Репозиторий связующий сущности.
     */
    private final UserProjectRepository userProjectRepository;
    /**
     * Репозиторий сущности пользователя.
     */
    private final UserRepository userRepository;
    /**
     * Репозиторий сущности проекта.
     */
    private final ProjectRepository projectRepository;

    /**
     * Получение списка пользователей участвующих в проекте.
     * @param projectId идентификатор проекта.
     * @return список пользователей.
     */
    public List<User> getUsersByProjectId(Long projectId){
        List<Long> usersId =
                userProjectRepository.findByProjectId(projectId)
                        .stream()
                        .map(UsersProject::getUserId)
                        .toList();
        return userRepository.findAllById(usersId);
    }

    /**
     * Получение проектов связанных с пользователем.
     * @param userId идентификатор пользователя.
     * @return список проектов.
     */
    public List<Project> getProjectsByUserId(Long userId){
        List<Long> projectsId = userProjectRepository.findByUserId(userId)
                .stream()
                .map(UsersProject::getProjectId)
                .toList();
        return projectRepository.findAllById(projectsId);
    }

    /**
     * Добавление пользователя к проекту.
     * @param userId идентификатор пользователя.
     * @param projectId идентификатор проекта.
     */
    @Transactional
    public void addUserToProject(Long userId, Long projectId){
        // проверка, корректны ли данные и что бы пользователя не участвовал в проекте
        if(checkUserInProject(userId, projectId)){
            throw new UserAlreadyInProjectException("User already in project!");
        }
        if(!checkResources(userId, projectId)){
            throw new ResourceNotFoundException();
        }

        UsersProject usersProject = new UsersProject();
        usersProject.setUserId(userId);
        usersProject.setProjectId(projectId);
        userProjectRepository.save(usersProject);
    }

    /**
     * Удаление пользователя из проекта.
     * @param userId идентификатор пользователя.
     * @param projectId идентификатор проекта.
     */
    @Transactional
    public void removeUserFromProject(Long userId, Long projectId){
        // проверка, корректны ли данные и участвует ли пользователь в проекте
        if(!checkResources(userId, projectId) || !checkUserInProject(userId, projectId)){
            throw new ResourceNotFoundException();
        }

        userProjectRepository.deleteByUserIdAndProjectId(userId, projectId);
    }

    /**
     * Служебный метод проверки участвует ли пользователь в проекте.
     * @param userId идентификатор пользователя.
     * @param projectId идентификатор проекта.
     * @return true - если пользователь в проекте, иначе false.
     */
    private boolean checkUserInProject(Long userId, Long projectId){
        List<UsersProject> usersProjects = userProjectRepository.findByUserId(userId);
        long count = usersProjects.stream()
                .filter(project -> project.getProjectId().equals(projectId))
                .count();
        return count > 0;
    }

    /**
     * Служебный метод проверки наличия объектов БД.
     * @param userId идентификатор пользователя.
     * @param projectId идентификатор проекта.
     * @return true - если оба объекта присутствуют, иначе false.
     */
    private boolean checkResources(Long userId, Long projectId){
        User user = userRepository.findById(userId).orElse(null);
        Project project = projectRepository.findById(projectId).orElse(null);
        return (user != null && project != null);
    }
}
