package com.example.demo.controllers;

import com.example.demo.entities.Project;
import com.example.demo.entities.Sprint;
import com.example.demo.services.IProjectServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
@RequiredArgsConstructor
public class ProjectController {
    private final IProjectServices iProjectServices ;

    @PostMapping
    public Project addProject(@RequestBody Project project, @RequestBody Sprint sprint) {
        return iProjectServices.addProject(project, sprint);
    }
    @PostMapping("/{idPorject}/sprints")
    public void addSprintAndAssignToProject(@RequestBody Sprint sprint, @PathVariable int idProject) {
        iProjectServices.addSprintAndAssignToProject(sprint, idProject);
    }


    @GetMapping("/current")
    public List<Project> getAllCurrentProject() {
        return iProjectServices.getAllCurrentProject();
    }

    @GetMapping("/scrum-master")
    public List<Project> getProjectsByScrumMaster(@RequestParam String firstName, @RequestParam String lastName) {
        return iProjectServices.getProjectsByScrumMaster(firstName, lastName);
    }

    @GetMapping("/sprint-count")
    public List<Project> getNbrSprintByCurrentProject() {
        return iProjectServices.getNbrSprintByCurrentProject();
    }
}
