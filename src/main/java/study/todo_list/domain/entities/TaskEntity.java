package study.todo_list.domain.entities;

import study.todo_list.domain.enums.ProjectPriorityEnum;
import study.todo_list.domain.enums.TaskStatusEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class TaskEntity {
    private UUID id;
    private String title;
    private String description;
    private TaskStatusEnum status;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private ProjectPriorityEnum priority;
    private UUID projectId;
    private UUID parentTaskId;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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
}
