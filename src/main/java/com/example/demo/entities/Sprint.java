package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idSprint;
    private String description ;
    private Date startDate ;

    @ManyToOne
    private Project projet;
    private Project parent;

    public void setParent(Project parent) {
        this.parent = parent;
    }

    public Project getParent() {
        return parent;
    }
}

