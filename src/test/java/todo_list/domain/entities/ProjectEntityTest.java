package todo_list.domain.entities;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static todo_list.data.factories.project.ProjectEntityDataFactory.generateNull;
import static todo_list.data.factories.project.ProjectEntityDataFactory.generateProject;

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

        assertThat(project).isEqualTo(generatedProject);
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

        assertThat(project).isEqualTo(generatedProject);
    }

    @Test
    void shouldUpdateDataToNull() {
        generatedProject.setId(null);
        generatedProject.setName(null);
        generatedProject.setDescription(null);
        generatedProject.setCreatedAt(null);
        generatedProject.setDeadline(null);
        generatedProject.setPriority(null);

        assertThat(generatedProject).isEqualTo(generateNull());
    }
}