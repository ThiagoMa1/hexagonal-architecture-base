package study.todo_list.data.factories.project;

import study.todo_list.domain.entities.ProjectEntity;
import study.todo_list.usecases.project.dtos.ProjectGetByIdDto;
import study.todo_list.usecases.project.dtos.ProjectSaveDto;
import study.todo_list.usecases.project.dtos.ProjectUpdateDto;

import static study.todo_list.data.factories.project.ProjectEntityDataFactory.generateProject;

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
                isInputReceived && input.priority() != null ? input.priority() : getCachedProject().getPriority()
        );
    }

    public static ProjectSaveDto generateProjectSaveDto() {
        return new ProjectSaveDto(
                getCachedProject().getName(),
                getCachedProject().getDescription(),
                getCachedProject().getDeadline(),
                getCachedProject().getPriority()
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
