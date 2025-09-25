package study.todo_list.domain.entities;

import org.junit.jupiter.api.Test;
import study.todo_list.data.factories.project.ProjectDtoDataFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static study.todo_list.data.factories.project.ProjectEntityDataFactory.generateProject;

class ProjectEntityTest {
    ProjectEntity generatedProject = generateProject();

    @Test
    void shouldCreateProjectWithConstructor() {
        ProjectEntity project = new ProjectEntity(
                generatedProject.getId(),
                generatedProject.getName(),
                generatedProject.getDescription(),
                generatedProject.getCreatedAt(),
                generatedProject.getDeadline(),
                generatedProject.getPriority()
        );

        assertEquals(generatedProject.getId(), project.getId());
        assertEquals(generatedProject.getName(), project.getName());
        assertEquals(generatedProject.getDescription(), project.getDescription());
        assertEquals(generatedProject.getCreatedAt(), project.getCreatedAt());
        assertEquals(generatedProject.getDeadline(), project.getDeadline());
        assertEquals(generatedProject.getPriority(), project.getPriority());
    }

    @Test
    void shouldCreateProjectWithSetters() {
        ProjectEntity project = new ProjectEntity();

        project.setId(generatedProject.getId());
        project.setName(generatedProject.getName());
        project.setDescription(generatedProject.getDescription());
        project.setCreatedAt(generatedProject.getCreatedAt());
        project.setDeadline(generatedProject.getDeadline());
        project.setPriority(generatedProject.getPriority());

        assertEquals(generatedProject.getId(), project.getId());
        assertEquals(generatedProject.getName(), project.getName());
        assertEquals(generatedProject.getDescription(), project.getDescription());
        assertEquals(generatedProject.getCreatedAt(), project.getCreatedAt());
        assertEquals(generatedProject.getDeadline(), project.getDeadline());
        assertEquals(generatedProject.getPriority(), project.getPriority());
    }

    @Test
    void shouldUpdateDataToNull() {
        ProjectDtoDataFactory.generateProjectGetByIdDto();
        ProjectDtoDataFactory.generateProjectGetByIdDto();
        generatedProject.setId(null);
        generatedProject.setName(null);
        generatedProject.setDescription(null);
        generatedProject.setCreatedAt(null);
        generatedProject.setDeadline(null);
        generatedProject.setPriority(null);

        assertNull(generatedProject.getId());
        assertNull(generatedProject.getName());
        assertNull(generatedProject.getDescription());
        assertNull(generatedProject.getCreatedAt());
        assertNull(generatedProject.getDeadline());
        assertNull(generatedProject.getPriority());
    }
}