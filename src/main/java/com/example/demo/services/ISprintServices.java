package com.example.demo.services;

import com.example.demo.entities.Sprint;

import java.time.LocalDate;
import java.util.List;

public interface ISprintServices {
    static List<Sprint> findByProjectIdAndStartDateAfter(int idProject, LocalDate startDate) {
        return null;
    }


}
