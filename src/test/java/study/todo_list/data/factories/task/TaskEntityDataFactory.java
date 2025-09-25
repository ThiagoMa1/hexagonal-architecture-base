package study.todo_list.data.factories.task;

import study.todo_list.domain.entities.TaskEntity;
import study.todo_list.domain.enums.ProjectPriorityEnum;
import study.todo_list.domain.enums.TaskStatusEnum;
import study.todo_list.utility.helpers.UuidHelper;

import java.time.LocalDateTime;

public class TaskEntityDataFactory {
    private static TaskEntity generate(TaskEntity input) {
        boolean isInputReceived = input != null;

        return new TaskEntity(
                isInputReceived && input.getId() != null ? input.getId() : UuidHelper.generate(),
                isInputReceived && input.getTitle() != null ? input.getTitle() : "Weekend Task",
                isInputReceived && input.getDescription() != null ? input.getDescription() : "Weekend Task Description",
                isInputReceived && input.getStatus() != null ? input.getStatus() : TaskStatusEnum.PENDING,
                isInputReceived && input.getDueDate() != null ? input.getDueDate() : LocalDateTime.now().plusDays(10),
                isInputReceived && input.getPriority() != null ? input.getPriority() : ProjectPriorityEnum.MEDIUM,
                isInputReceived && input.getProjectId() != null ? input.getProjectId() : UuidHelper.generate(),
                isInputReceived && input.getParentTaskId() != null ? input.getParentTaskId() : UuidHelper.generate(),
                isInputReceived && input.getCreatedAt() != null ? input.getCreatedAt() : LocalDateTime.now(),
                isInputReceived && input.getUpdatedAt() != null ? input.getUpdatedAt() : LocalDateTime.now()
        );
    }

    private static TaskEntity generateInvalid(TaskEntity input) {
        boolean isInputReceived = input != null;

        return new TaskEntity(
                isInputReceived && input.getId() != null ? input.getId() : null,
                isInputReceived && input.getTitle() != null ? input.getTitle() : null,
                isInputReceived && input.getDescription() != null ? input.getDescription() : null,
                isInputReceived && input.getStatus() != null ? input.getStatus() : null,
                isInputReceived && input.getDueDate() != null ? input.getDueDate() : null,
                isInputReceived && input.getPriority() != null ? input.getPriority() : null,
                isInputReceived && input.getProjectId() != null ? input.getProjectId() : null,
                isInputReceived && input.getParentTaskId() != null ? input.getParentTaskId() : null,
                isInputReceived && input.getCreatedAt() != null ? input.getCreatedAt() : LocalDateTime.now().plusDays(10),
                isInputReceived && input.getUpdatedAt() != null ? input.getUpdatedAt() : LocalDateTime.now().plusDays(10)
        );
    }

    public static TaskEntity generateNull() {
        return new TaskEntity(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public static TaskEntity generateTask(TaskEntity input) {
        return generate(input);
    }

    public static TaskEntity generateTask() {
        return generate(null);
    }

    public static TaskEntity generateTaskInvalid(TaskEntity input) {
        return generateInvalid(input);
    }

    public static TaskEntity generateTaskInvalid() {
        return generateInvalid(null);
    }
}
