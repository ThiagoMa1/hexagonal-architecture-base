package todo_list.data.factories.project;

import todo_list.domain.entities.ProjectEntity;
import todo_list.usecases.project.dtos.ProjectGetByIdDto;
import todo_list.usecases.project.dtos.ProjectSaveDto;
import todo_list.usecases.project.dtos.ProjectUpdateDto;

import static todo_list.data.factories.project.ProjectEntityDataFactory.generateProject;

public class ProjectDtoDataFactory {
    static ProjectEntity cachedProject = generateProject();

    private static ProjectEntity getCachedProject() {
        if (cachedProject == null) {
            cachedProject = generateProject();
        }
        return cachedProject;
    }

    public static ProjectGetByIdDto generateProjectGetByIdDto(ProjectGetByIdDto input) {
        boolean isInputReceived = input != null;

        return new ProjectGetByIdDto(isInputReceived && input.id() != null ? input.id() : getCachedProject().getId());
    }

    public static ProjectGetByIdDto generateProjectGetByIdDto() {
        return new ProjectGetByIdDto(getCachedProject().getId());
    }

    public static ProjectSaveDto generateProjectSaveDto(ProjectSaveDto input) {
        boolean isInputReceived = input != null;

        return new ProjectSaveDto(
                isInputReceived && input.name() != null ? input.name() : getCachedProject().getName(),
                isInputReceived && input.description() != null ? input.description() : getCachedProject().getDescription(),
                isInputReceived && input.deadline() != null ? input.deadline() : getCachedProject().getDeadline(),
                isInputReceived && input.priority() != null ? input.priority() : getCachedProject().getPriority().toString()
        );
    }

    public static ProjectSaveDto generateProjectSaveDto() {
        return new ProjectSaveDto(
                getCachedProject().getName(),
                getCachedProject().getDescription(),
                getCachedProject().getDeadline(),
                getCachedProject().getPriority().toString()
        );
    }

    public static ProjectUpdateDto generateProjectUpdateDto(ProjectUpdateDto input) {
        boolean isInputReceived = input != null;

        return new ProjectUpdateDto(
                isInputReceived && input.name() != null ? input.name() : getCachedProject().getName(),
                isInputReceived && input.description() != null ? input.description() : getCachedProject().getDescription(),
                isInputReceived && input.deadline() != null ? input.deadline() : getCachedProject().getDeadline(),
                isInputReceived && input.priority() != null ? input.priority() : getCachedProject().getPriority()
        );
    }

    public static ProjectUpdateDto generateProjectUpdateDto() {
        return new ProjectUpdateDto(
                getCachedProject().getName(),
                getCachedProject().getDescription(),
                getCachedProject().getDeadline(),
                getCachedProject().getPriority()
        );
    }
}
