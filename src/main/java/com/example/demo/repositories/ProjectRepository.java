package com.example.demo.repositories;

import com.example.demo.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project , Integer> {
    @Query("SELECT DISTINCT p FROM Project p JOIN p.sprints s WHERE s.startDate > CURRENT_DATE")
    List<Project> findAllCurrentProjects();

    @Query("SELECT p FROM Project p JOIN p.users sm WHERE sm.role = 'SCRUM_MASTER' AND sm.firstName = :fName AND sm.lastName = :lName")
    List<Project> findProjectsByScrumMaster(@Param("fName") String firstName, @Param("lName") String lastName);
}
