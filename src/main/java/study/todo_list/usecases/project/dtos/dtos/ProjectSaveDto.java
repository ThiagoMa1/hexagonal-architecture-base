package study.todo_list.usecases.project.dtos.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import study.todo_list.domain.enums.ProjectPriorityEnum;

import java.time.LocalDateTime;

public record ProjectSaveDto(
        @NotNull @Size(min = 3, max = 55) String name,
        @Size(min = 3, max = 200) String description,
        ProjectPriorityEnum priority,
        LocalDateTime deadline
) {
    public ProjectSaveDto {
        if (priority == null) priority = ProjectPriorityEnum.LOW;
    }
}
