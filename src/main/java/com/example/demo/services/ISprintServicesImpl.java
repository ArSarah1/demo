package com.example.demo.services;

import com.example.demo.entities.Sprint;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ISprintServicesImpl implements ISprintServices {

    public List<Sprint> findByProjectIdAndStartDateAfter(int idProject, LocalDate startDate) {
        return ISprintServices.findByProjectIdAndStartDateAfter(idProject, startDate);

    }
}
