package com.taskmanagement.demo.application;

import com.taskmanagement.demo.domain.Priority;
import com.taskmanagement.demo.domain.Task;
import com.taskmanagement.demo.infrastructure.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(String name, Priority priority) {
        Task task = new Task();
        task.setName(name);
        task.setPriority(priority);
        task.setCreated(Instant.now());
        task.setDone(false);
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, String name, boolean done) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setName(name);
        task.setDone(done);
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
