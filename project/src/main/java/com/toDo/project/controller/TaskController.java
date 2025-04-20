package com.toDo.project.controller;

import com.toDo.project.model.Task;
import com.toDo.project.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
@CrossOrigin("http://127.0.0.1:5500")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    public ResponseEntity<Task> save(@RequestBody Task task) {
        Task savedTask = this.taskService.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        return ResponseEntity.ok(this.taskService.findAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.taskService.delete(id);
    }

    @PutMapping("/{id}")
    public void userUpdate(@PathVariable Long id, @RequestBody Task task) {
        Task updatedTask = this.taskService.update(id, task);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> patch(@PathVariable Long id, @RequestBody Map <String, Boolean> body) {
        Boolean completed = body.get("completed");
        Task task = this.taskService.findById(id);

        if(task==null){
            return ResponseEntity.notFound().build();
        }
        this.taskService.updateCompleted(id,completed);
        return ResponseEntity.ok(task);
    }
}
