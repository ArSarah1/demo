package com.example.demo.services;

import com.example.demo.entities.Project;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.ProjectRepository;
import com.example.demo.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServicesImpl  implements IUserServices{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void assignProjectToUser(int idProject, int idUser) {
        User user = userRepository.findById(idUser).orElseThrow(() -> new EntityNotFoundException("User not found"));
        Project project = projectRepository.findById(idProject).orElseThrow(() -> new EntityNotFoundException("Project not found"));
        user.getProjects().add(project);
        userRepository.save(user);
    }

    @Override
    public void assignProjectToClient(int idProject, String firstName, String lastName) {
        User user = userRepository.findByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (user.getRole() == Role.CLIENT) {
            Project project = projectRepository.findById(idProject)
                    .orElseThrow(() -> new EntityNotFoundException("Project not found"));
            user.getProjects().add(project);
            userRepository.save(user);
        } else {
            throw new RuntimeException("User is not a client");
        }
    }

}
