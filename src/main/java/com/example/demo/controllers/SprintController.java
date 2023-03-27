package com.example.demo.controllers;

import com.example.demo.services.ISprintServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sprints")
@RequiredArgsConstructor
public class SprintController {
    private final ISprintServices iSprintServices ;
}
