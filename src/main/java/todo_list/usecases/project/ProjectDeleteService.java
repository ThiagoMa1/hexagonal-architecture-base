package todo_list.usecases.project;

import org.springframework.stereotype.Service;
import todo_list.domain.entities.ProjectEntity;
import todo_list.domain.interfaces.general.ServiceInterface;
import todo_list.utility.helpers.UuidHelper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectDeleteService implements ServiceInterface<UUID, Optional<ProjectEntity>> {
    List<ProjectEntity> projects;

    public ProjectDeleteService() {
        ProjectEntity project = new ProjectEntity();
        project.setId(UuidHelper.generate());
        project.setName("Random name");
        project.setDescription("Testing Description");
        project.setDeadline(LocalDateTime.now());
        project.setCreatedAt(LocalDateTime.now());
        this.projects = new ArrayList<>();
    }

    @Override
    public Optional<ProjectEntity> execute(UUID input) throws ClassNotFoundException {
        Optional<ProjectEntity> project = this.projects.stream()
                .filter(((p) -> p.getId() == input))
                .findFirst();

        if (project.isEmpty()) throw new ClassNotFoundException("Project not found");

        return project;
    }
}
