package com.master.listedetaches.service.impl;

import com.master.listedetaches.dto.TaskRequest;
import com.master.listedetaches.dto.TaskResponse;
import com.master.listedetaches.exception.ResourceNotFoundException;
import com.master.listedetaches.model.Status;
import com.master.listedetaches.model.Task;
import com.master.listedetaches.repository.TaskRepository;
import com.master.listedetaches.service.TaskService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskResponse create(TaskRequest request) {
        Task task = new Task();
        task.setTitre(request.getTitre());
        task.setDescription(request.getDescription());
        task.setStatut(Status.EN_COURS);

        return mapToResponse(repository.save(task));
    }



    @Override
    public TaskResponse update(Long id, TaskRequest request) {
        Task existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tache introuvable"));

        existing.setTitre(request.getTitre());
        existing.setDescription(request.getDescription());

        Task updated = repository.save(existing);
        return mapToResponse(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TaskResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public TaskResponse markAsCompleted(Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tache introuvable"));

        task.setStatut(Status.TERMINE);

        Task updated = repository.save(task);

        return mapToResponse(updated);
    }









    private TaskResponse mapToResponse(Task task) {
        TaskResponse response = new TaskResponse();
        response.setId(task.getId());
        response.setTitre(task.getTitre());
        response.setDescription(task.getDescription());
        response.setStatut(task.getStatut());

        return response;
    }





}
