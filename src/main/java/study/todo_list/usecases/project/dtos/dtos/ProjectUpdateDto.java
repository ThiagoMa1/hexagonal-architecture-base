package study.todo_list.usecases.project.dtos.dtos;

import jakarta.validation.constraints.Size;
import study.todo_list.domain.enums.ProjectPriorityEnum;

import java.time.LocalDateTime;

public record ProjectUpdateDto(
        @Size(min = 3, max = 55) String name,
        @Size(min = 3, max = 200) String description,
        ProjectPriorityEnum priority,
        LocalDateTime deadline
) {
}
