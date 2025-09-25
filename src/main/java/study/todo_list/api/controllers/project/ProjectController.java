package study.todo_list.api.controllers.project;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import study.todo_list.usecases.project.*;
import study.todo_list.usecases.project.dtos.ProjectSaveDto;
import study.todo_list.usecases.project.dtos.ProjectUpdateDto;
import study.todo_list.domain.entities.ProjectEntity;
import study.todo_list.utility.validators.IsUUID;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("projects")
public class ProjectController {
    private final ProjectGetAllService projectGetAllService;
    private final ProjectGetByIdService projectGetByIdService;
    private final ProjectSaveService projectSaveService;
    private final ProjectUpdateService projectUpdateService;
    private final ProjectDeleteService projectDeleteService;

    public ProjectController(ProjectGetAllService projectGetAllService, ProjectGetByIdService projectGetByIdService, ProjectSaveService projectSaveService, ProjectUpdateService projectUpdateService, ProjectDeleteService projectDeleteService) {
        this.projectGetAllService = projectGetAllService;
        this.projectGetByIdService = projectGetByIdService;
        this.projectSaveService = projectSaveService;
        this.projectUpdateService = projectUpdateService;
        this.projectDeleteService = projectDeleteService;
    }

    @GetMapping()
    public List<ProjectEntity> getAll() throws Exception {
        return this.projectGetAllService.execute(null);
    }

    @GetMapping("/{id}")
    public Optional<ProjectEntity> getById(@Valid @PathVariable("id") @IsUUID UUID id) throws ClassNotFoundException {
        System.out.println(id);
        return this.projectGetByIdService.execute(id);
    }

    @PostMapping()
    public ProjectEntity save(@Valid @RequestBody ProjectSaveDto body) {
        return this.projectSaveService.execute(body);
    }

    @PutMapping("/{id}")
    public ProjectEntity update(
            @Valid @PathVariable("id") @IsUUID String id,
            @Valid @RequestBody ProjectUpdateDto body
            ) {
        return this.projectUpdateService.execute(body);
    }

    @DeleteMapping("/{id}")
    public Optional<ProjectEntity> delete(@Valid @PathVariable("id") @IsUUID UUID id) throws ClassNotFoundException {
        return this.projectDeleteService.execute(id);
    }
}
