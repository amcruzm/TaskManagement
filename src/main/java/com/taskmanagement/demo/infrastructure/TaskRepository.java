package com.taskmanagement.demo.infrastructure;

import com.taskmanagement.demo.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
