package com.master.listedetaches.controller;

import com.master.listedetaches.dto.TaskRequest;
import com.master.listedetaches.dto.TaskResponse;
import com.master.listedetaches.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/taches")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> create(@RequestBody TaskRequest request){

        return ResponseEntity.ok(service.create(request));
    }
    @PutMapping("/{id}")
    public  ResponseEntity<TaskResponse> update(
            @PathVariable Long id,
            @RequestBody TaskRequest request){
        return ResponseEntity.ok(service.update(id, request));
    }







    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TaskResponse> markAsCompleted(@PathVariable Long id){
        return ResponseEntity.ok(service.markAsCompleted(id));
    }

}
