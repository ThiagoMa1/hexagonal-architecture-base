package study.todo_list.data.factories.project;

import study.todo_list.domain.entities.ProjectEntity;
import study.todo_list.domain.enums.ProjectPriorityEnum;
import study.todo_list.utility.helpers.UuidHelper;

import java.time.LocalDateTime;

public class ProjectEntityDataFactory {
    private static ProjectEntity generate(ProjectEntity input) {
        boolean isInputReceived = input != null;

        return new ProjectEntity(
                isInputReceived && input.getId() != null ? input.getId() : UuidHelper.generate(),
                isInputReceived && input.getName() != null ? input.getName() : "Weekend Project",
                isInputReceived && input.getDescription() != null ? input.getDescription() : "Weekend Project Description",
                isInputReceived && input.getCreatedAt() != null ? input.getCreatedAt() : LocalDateTime.now(),
                isInputReceived && input.getDeadline() != null ? input.getDeadline() : LocalDateTime.now().plusDays(10),
                isInputReceived && input.getPriority() != null ? input.getPriority() : ProjectPriorityEnum.MEDIUM
        );
    }

    private static ProjectEntity generateInvalid(ProjectEntity input) {
        boolean isInputReceived = input != null;

        return new ProjectEntity(
                isInputReceived && input.getId() != null ? input.getId() : null,
                isInputReceived && input.getName() != null ? input.getName() : null,
                isInputReceived && input.getDescription() != null ? input.getDescription() : "a",
                isInputReceived && input.getCreatedAt() != null ? input.getCreatedAt() : LocalDateTime.now().plusDays(10),
                isInputReceived && input.getDeadline() != null ? input.getDeadline() : LocalDateTime.now().minusDays(10),
                isInputReceived && input.getPriority() != null ? input.getPriority() : null
        );
    }

    public static ProjectEntity generateProject(ProjectEntity input) {
        return generate(input);
    }

    public static ProjectEntity generateProject() {
        return generate(null);
    }

    public static ProjectEntity generateProjectInvalid(ProjectEntity input) {
        return generateInvalid(input);
    }

    public static ProjectEntity generateProjectInvalid() {
        return generateInvalid(null);
    }
}
