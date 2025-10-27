package todo_list.usecases.project;

import org.springframework.stereotype.Service;
import todo_list.domain.enums.ProjectPriorityEnum;
import todo_list.domain.interfaces.repositories.ProjectRepositoryInterface;
import todo_list.usecases.project.dtos.ProjectSaveDto;
import todo_list.domain.entities.ProjectEntity;
import todo_list.domain.interfaces.general.ServiceInterface;
import todo_list.utility.helpers.UuidHelper;

import java.time.LocalDateTime;

@Service
public class ProjectSaveService implements ServiceInterface<ProjectSaveDto, ProjectEntity> {
//    private final ProjectRepositoryInterface projectRepository;
//
//    public ProjectSaveService(ProjectRepositoryInterface projectRepositoryInterface) {
//        this.projectRepository = projectRepositoryInterface;
//    }

    @Override
    public ProjectEntity execute(ProjectSaveDto input) {
        ProjectEntity project = new ProjectEntity(
                UuidHelper.generate(),
                input.name(),
                String.valueOf(input.description()),
                LocalDateTime.now(),
                input.deadline(),
                ProjectPriorityEnum.valueOf(input.priority())
        );

        return project;
    }
}
