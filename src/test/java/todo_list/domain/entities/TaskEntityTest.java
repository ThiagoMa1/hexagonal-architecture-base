package todo_list.domain.entities;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static todo_list.data.factories.task.TaskEntityDataFactory.generateNull;
import static todo_list.data.factories.task.TaskEntityDataFactory.generateTask;

class TaskEntityTest {
    TaskEntity generatedTask = generateTask();

    @Test
    void shouldCreateTaskWithConstructor() {
        TaskEntity task = new TaskEntity(
                generatedTask.getId(),
                generatedTask.getTitle(),
                generatedTask.getDescription(),
                generatedTask.getStatus(),
                generatedTask.getDueDate(),
                generatedTask.getPriority(),
                generatedTask.getProjectId(),
                generatedTask.getParentTaskId(),
                generatedTask.getCreatedAt(),
                generatedTask.getUpdatedAt()
        );

        assertThat(task).isEqualTo(generatedTask);
    }

    @Test
    void shouldCreateTaskWithSetters() {
        TaskEntity task = new TaskEntity();

        task.setId(generatedTask.getId());
        task.setTitle(generatedTask.getTitle());
        task.setDescription(generatedTask.getDescription());
        task.setStatus(generatedTask.getStatus());
        task.setDueDate(generatedTask.getDueDate());
        task.setPriority(generatedTask.getPriority());
        task.setProjectId(generatedTask.getProjectId());
        task.setParentTaskId(generatedTask.getParentTaskId());
        task.setCreatedAt(generatedTask.getCreatedAt());
        task.setUpdatedAt(generatedTask.getUpdatedAt());

        assertThat(task).isEqualTo(generatedTask);
    }

    @Test
    void shouldUpdateDataToNull() {
        generatedTask.setId(null);
        generatedTask.setTitle(null);
        generatedTask.setDescription(null);
        generatedTask.setStatus(null);
        generatedTask.setDueDate(null);
        generatedTask.setPriority(null);
        generatedTask.setProjectId(null);
        generatedTask.setParentTaskId(null);
        generatedTask.setCreatedAt(null);
        generatedTask.setUpdatedAt(null);

        assertThat(generateNull()).isEqualTo(generatedTask);
    }
}