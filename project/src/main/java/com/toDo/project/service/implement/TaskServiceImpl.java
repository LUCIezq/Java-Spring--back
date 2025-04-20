package com.toDo.project.service.implement;

import com.toDo.project.model.Task;
import com.toDo.project.repository.TaskRepository;
import com.toDo.project.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task save(Task task) {
        return this.taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        this.taskRepository.deleteById(id);
    }

    @Override
    public Task update(Long id, Task task) {
        task.setId(id);
        task.setTitle(task.getTitle());
        task.setDescription(task.getDescription());
        return this.taskRepository.save(task);
    }

    @Override
    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return this.taskRepository.findById(id).get();
    }

    @Override
    public void updateCompleted(Long id, Boolean completed) {
    Task task = this.taskRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Task not found"));
    task.setCompleted(completed);
        this.taskRepository.save(task);
    }
}
