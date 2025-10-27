package todo_list.usecases.project;

import org.springframework.stereotype.Service;
import todo_list.domain.entities.ProjectEntity;
import todo_list.domain.interfaces.general.ServiceInterface;
import todo_list.utility.helpers.UuidHelper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectGetAllService implements ServiceInterface<Void, List<ProjectEntity>> {

    List<ProjectEntity> projects;

    public ProjectGetAllService() {
        ProjectEntity project = new ProjectEntity();
        project.setId(UuidHelper.generate());
        project.setName("Random name");
        project.setDescription("Testing Description");
        project.setDeadline(LocalDateTime.now());
        project.setCreatedAt(LocalDateTime.now());
        this.projects = new ArrayList<>();
        projects.add(project);
    }

    @Override
    public List<ProjectEntity> execute(Void input) {
        return this.projects;
    }
}
