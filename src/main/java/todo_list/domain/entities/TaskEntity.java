package todo_list.domain.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import todo_list.domain.enums.ProjectPriorityEnum;
import todo_list.domain.enums.TaskStatusEnum;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    private UUID id;
    private String title;
    private String description;
    private TaskStatusEnum status;
    private LocalDateTime dueDate;
    private ProjectPriorityEnum priority;
    private UUID projectId;
    private UUID parentTaskId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskEntity task = (TaskEntity) o;

        return Objects.equals(id, task.id) &&
                Objects.equals(title, task.title) &&
                Objects.equals(description, task.description) &&
                status == task.status &&
                Objects.equals(dueDate, task.dueDate) &&
                priority == task.priority &&
                Objects.equals(projectId, task.projectId) &&
                Objects.equals(parentTaskId, task.parentTaskId) &&
                Objects.equals(createdAt, task.createdAt) &&
                Objects.equals(updatedAt, task.updatedAt);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public ProjectPriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(ProjectPriorityEnum priority) {
        this.priority = priority;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public UUID getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(UUID parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
