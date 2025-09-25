package study.todo_list.usecases.project;

import org.springframework.stereotype.Service;
import study.todo_list.usecases.project.dtos.ProjectUpdateDto;
import study.todo_list.domain.entities.ProjectEntity;
import study.todo_list.domain.interfaces.general.ServiceInterface;
import study.todo_list.utility.helpers.UuidHelper;

import java.time.LocalDateTime;

@Service
public class ProjectUpdateService implements ServiceInterface<ProjectUpdateDto, ProjectEntity> {

    @Override
    public ProjectEntity execute(ProjectUpdateDto input) {
        ProjectEntity project = new ProjectEntity();
        project.setId(UuidHelper.generate());
        project.setName(String.valueOf(input.name()));
        project.setDescription(String.valueOf(input.description()));
        project.setDeadline(input.deadline());
        project.setCreatedAt(LocalDateTime.now());

        return project;
    }
}
