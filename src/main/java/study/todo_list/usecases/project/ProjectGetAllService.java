package study.todo_list.usecases.project;

import org.springframework.stereotype.Service;
import study.todo_list.domain.entities.ProjectEntity;
import study.todo_list.domain.interfaces.general.ServiceInterface;
import study.todo_list.utility.helpers.UuidHelper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectGetAllService implements ServiceInterface<Void, List<ProjectEntity>> {

    List<ProjectEntity> projects;

    public ProjectGetAllService() {
        ProjectEntity project = new ProjectEntity();
        project.setId(UuidHelper.generate());
        project.setName("Random name");
        project.setDescription(String.valueOf("Testing Description"));
        project.setDeadline(Optional.of(LocalDateTime.now()));
        project.setCreatedAt(LocalDateTime.now());
        this.projects = new ArrayList<>();
        projects.add(project);
    }

    @Override
    public List<ProjectEntity> execute(Void input) {
        return this.projects;
    }
}
