package com.example.demo.services;

import com.example.demo.entities.Project;
import com.example.demo.entities.Sprint;

import java.time.LocalDate;
import java.util.List;

public interface IProjectServices {
    public Project addProject(Project project , Sprint sprint);
    public List<Project> getAllCurrentProject();

    public List<Project> getProjectsByScrumMaster(String firstName, String lastName) ;
    public void addSprintAndAssignToProject(Sprint sprint, int idPorject);



    List<Project> getNbrSprintByCurrentProject();
}
