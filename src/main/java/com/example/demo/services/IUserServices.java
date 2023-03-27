package com.example.demo.services;

import com.example.demo.entities.User;

public interface IUserServices {
    public User addUser (User user);
    public void assignProjectToUser(int projectId, int userId) ;
    public void assignProjectToClient(int idProject, String firstName, String lastName);
}
