package com.toDo.project.service;

import com.toDo.project.model.Task;

import java.util.List;

public interface TaskService {
    Task save(Task task);

    void delete(Long id);

    Task update(Long id, Task task);

    List<Task> findAll();

    Task findById(Long id);

    void updateCompleted(Long id, Boolean completed);
}
