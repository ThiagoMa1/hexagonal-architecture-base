package study.todo_list.usecases.project.dtos.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import study.todo_list.domain.enums.ProjectPriorityEnum;

import java.time.LocalDateTime;
import java.util.Optional;

public record ProjectSaveDto(
        @NotNull @Size(min = 3, max = 55) String name,
        @Size(min = 3, max = 200) Optional<String> description,
        Optional<ProjectPriorityEnum> priority,
        Optional<LocalDateTime> deadline
) {
    public ProjectSaveDto {
        if (priority.isEmpty()) priority = Optional.of(ProjectPriorityEnum.LOW);
    }
}
