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
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idProject ;
    private String title ;
    private String descriprtion ;

    @OneToMany(mappedBy = "projet")
    private List<Sprint> sprints ;

    @ManyToMany (mappedBy = "projets")
    private List<User> users;

    @ManyToOne()
    private User user;
}
