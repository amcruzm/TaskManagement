package com.taskmanagement.demo.application;

import com.taskmanagement.demo.domain.Priority;
import com.taskmanagement.demo.domain.Task;

import java.util.List;

public interface TaskService {
    Task createTask(String name, Priority priority);
    Task updateTask(Long id, String name, boolean done);
    void deleteTask(Long id);
    List<Task> getAllTasks();
}
