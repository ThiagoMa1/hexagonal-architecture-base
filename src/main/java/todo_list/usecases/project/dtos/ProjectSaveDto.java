package todo_list.usecases.project.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import todo_list.domain.enums.ProjectPriorityEnum;
import todo_list.utility.validators.annotations.ValidEnum;

import java.time.LocalDateTime;

public record ProjectSaveDto(
        @NotNull @Size(min = 3, max = 55) String name,
        @Size(min = 3, max = 200) String description,
        LocalDateTime deadline,
        @ValidEnum(enumClass = ProjectPriorityEnum.class) String priority
) {
    public ProjectSaveDto {
        if (priority == null || priority.isEmpty()) priority = ProjectPriorityEnum.LOW.toString();
    }
}
