package com.master.listedetaches.service;

import com.master.listedetaches.dto.TaskRequest;
import com.master.listedetaches.dto.TaskResponse;

import java.util.List;

public interface TaskService {
    TaskResponse create(TaskRequest request);

    TaskResponse update(Long id, TaskRequest request);

    void delete(Long id);

    List<TaskResponse> getAll();

    TaskResponse markAsCompleted(Long id);
}
