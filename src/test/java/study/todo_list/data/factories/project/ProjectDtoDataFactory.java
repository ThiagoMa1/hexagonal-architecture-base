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

        return new ProjectGetByIdDto(isInputReceived && input.id() != null ? input.id() : cachedProject.getId());
    }

    public static ProjectGetByIdDto generateProjectGetByIdDto() {
        return new ProjectGetByIdDto(cachedProject.getId());
    }

    public static ProjectSaveDto generateProjectSaveDto(ProjectSaveDto input) {
        boolean isInputReceived = input != null;

        return new ProjectSaveDto(
                isInputReceived && input.name() != null ? input.name() : cachedProject.getName(),
                isInputReceived && input.description() != null ? input.description() : cachedProject.getDescription(),
                isInputReceived && input.deadline() != null ? input.deadline() : cachedProject.getDeadline(),
                isInputReceived && input.priority() != null ? input.priority() : cachedProject.getPriority()
        );
    }

    public static ProjectSaveDto generateProjectSaveDto() {
        return new ProjectSaveDto(
                cachedProject.getName(),
                cachedProject.getDescription(),
                cachedProject.getDeadline(),
                cachedProject.getPriority()
        );
    }

    public static ProjectUpdateDto generateProjectUpdateDto(ProjectUpdateDto input) {
        boolean isInputReceived = input != null;

        return new ProjectUpdateDto(
                isInputReceived && input.name() != null ? input.name() : cachedProject.getName(),
                isInputReceived && input.description() != null ? input.description() : cachedProject.getDescription(),
                isInputReceived && input.deadline() != null ? input.deadline() : cachedProject.getDeadline(),
                isInputReceived && input.priority() != null ? input.priority() : cachedProject.getPriority()
        );
    }

    public static ProjectUpdateDto generateProjectUpdateDto() {
        return new ProjectUpdateDto(
                cachedProject.getName(),
                cachedProject.getDescription(),
                cachedProject.getDeadline(),
                cachedProject.getPriority()
        );
    }
}
