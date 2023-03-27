package com.example.demo.services;

import com.example.demo.entities.Project;
import com.example.demo.entities.Sprint;
import com.example.demo.repositories.ProjectRepository;
import com.example.demo.repositories.SprintRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class IProjectServicesImpl implements IProjectServices{

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private SprintRepository sprintRepository ;

    @Transactional
    public Project addProject(Project project, Sprint sprint) {
        sprintRepository.save(sprint);
        project.getSprints().add(sprint);
        return projectRepository.save(project);
    }

    public List<Project> getAllCurrentProject() {
        return projectRepository.findAllCurrentProjects();
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String firstName, String lastName) {
        return projectRepository.findProjectsByScrumMaster(firstName, lastName);
    }

    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Project project = projectRepository.findById(idProject).orElseThrow(() -> new IllegalArgumentException("Project not found"));
        sprint.setParent(project);
        project.getSprints().add(sprint);
        projectRepository.save(project);
    }

    public static final Logger logger = LoggerFactory.getLogger(IProjectServices.class);
    @Scheduled(fixedRate = 30000)
    public void logNumberOfSprintsByCurrentProject() {
        List<Project> currentProjects = projectRepository.findAllCurrentProjects();
        for (Project project : currentProjects) {
            List<Sprint> sprints = sprintRepository.findByProjectIdAndStartDateAfter(project.getIdProject(), LocalDate.now());
            logger.info("Project {} has {} sprints in progress.", project.getDescriprtion(), sprints.size());
        }
    }

    public List<Project> getNbrSprintByCurrentProject() {
        return projectRepository.findAllCurrentProjects();
    }
}
