package study.todo_list.usecases.project.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record ProjectGetByIdDto(@NotNull @Size(min = 4, max = 10) UUID id) {}
