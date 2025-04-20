package com.toDo.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",nullable = false, length = 100)
    private String title;

    @Column(name = "description",nullable = false, length = 500)
    private String description;

    @Column(name = "completed",nullable = false, length = 500)
    private Boolean completed = false;
}
