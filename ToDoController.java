package com.example.demo.controller;

import com.example.demo.model.ToDo;
import com.example.demo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*")
public class ToDoController {

    @Autowired
    private ToDoService service;

    @GetMapping
    public List<ToDo> getAll() { return service.getAll(); }

    @PostMapping
    public ToDo create(@RequestBody ToDo todo) { return service.save(todo); }

    @PutMapping("/{id}")
    public ToDo update(@PathVariable Long id, @RequestBody ToDo todo) {
        return service.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
