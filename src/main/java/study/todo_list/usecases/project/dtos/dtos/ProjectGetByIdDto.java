package study.todo_list.usecases.project.dtos.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProjectGetByIdDto(@NotNull @Size(min = 4, max = 10) String id) {}
