package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idUser;
    private String email;
    private String pwd ;
    private String firstName ;
    private String lastName ;
    @Enumerated(EnumType.STRING)
    private Role role ;

    @ManyToMany
    private List<Project> projects;

    @OneToMany(mappedBy = "user")
    List<Project> proj;

}
