package com.example.demo.repositories;

import com.example.demo.entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint,Integer> {
    List<Sprint> findByProjectIdAndStartDateAfter(int idProject, LocalDate now);
}
