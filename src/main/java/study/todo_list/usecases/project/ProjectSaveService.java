package study.todo_list.usecases.project;

import org.springframework.stereotype.Service;
import study.todo_list.usecases.project.dtos.dtos.ProjectSaveDto;
import study.todo_list.domain.entities.ProjectEntity;
import study.todo_list.domain.interfaces.general.ServiceInterface;
import study.todo_list.utility.helpers.UuidHelper;

import java.time.LocalDateTime;

@Service
public class ProjectSaveService implements ServiceInterface<ProjectSaveDto, ProjectEntity> {

    @Override
    public ProjectEntity execute(ProjectSaveDto input) {
        ProjectEntity project = new ProjectEntity();
        project.setId(UuidHelper.generate());
        project.setName(input.name());
        project.setDescription(String.valueOf(input.description()));
        project.setDeadline(input.deadline());
        project.setCreatedAt(LocalDateTime.now());

        return project;
    }
}
