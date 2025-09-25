package study.todo_list.usecases.project;

import org.springframework.stereotype.Service;
import study.todo_list.domain.entities.ProjectEntity;
import study.todo_list.domain.interfaces.general.ServiceInterface;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ProjectGetByIdService implements ServiceInterface<UUID, Optional<ProjectEntity>> {
    List<ProjectEntity> projects = new ArrayList<>();

    public ProjectGetByIdService() {
        ProjectEntity project = new ProjectEntity();
        project.setId(UUID.fromString("fa79e222-61fd-4a7c-8a3e-b1779acc61ea"));
        project.setName("Random name");
        project.setDescription("Testing Description");
        project.setDeadline(LocalDateTime.now());
        project.setCreatedAt(LocalDateTime.now());
        this.projects.add(project);
    }

    @Override
    public Optional<ProjectEntity> execute(UUID input) throws ClassNotFoundException {
        Optional<ProjectEntity> project = this.projects.stream()
                .findFirst()
                .filter((p -> Objects.equals(p.getId(), input)));

        if (project.isEmpty()) throw new ClassNotFoundException("Project not found");

        return project;
    }
}
