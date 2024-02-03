package ru.gb.data2.Task2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.data2.Task2.models.Project;

/**
 * Репозиторий сущности проекта.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
