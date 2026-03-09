package com.master.listedetaches.repository;

import com.master.listedetaches.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
