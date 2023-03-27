package com.example.demo.controllers;

import com.example.demo.entities.Project;
import com.example.demo.entities.User;
import com.example.demo.services.IUserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final IUserServices iUserServices ;
    @PostMapping
    public User addUser(@RequestBody User user) {
        return iUserServices.addUser(user);
    }

    @PostMapping("/{idUser}/projects/{idProject}")
    public void assignProjectToUser(@PathVariable int idUser, @PathVariable int idProject) {
        iUserServices.assignProjectToUser(idProject, idUser);
    }
}
