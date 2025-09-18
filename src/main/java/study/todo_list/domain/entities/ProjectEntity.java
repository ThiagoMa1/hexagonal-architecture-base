package study.todo_list.domain.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import study.todo_list.domain.enums.ProjectPriorityEnum;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public class ProjectEntity {
    private UUID id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime deadline;
    private ProjectPriorityEnum priority;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public ProjectPriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(ProjectPriorityEnum priority) {
        this.priority = priority;
    }
}
