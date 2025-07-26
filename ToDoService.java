package com.example.demo.service;

import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository repo;

    public List<ToDo> getAll() { return repo.findAll(); }

    public ToDo save(ToDo todo) { return repo.save(todo); }

    public ToDo update(Long id, ToDo todo) {
        ToDo existing = repo.findById(id).orElseThrow();
        existing.setTitle(todo.getTitle());
        existing.setDescription(todo.getDescription());
        existing.setCompleted(todo.isCompleted());
        return repo.save(existing);
    }

    public void delete(Long id) { repo.deleteById(id); }
}
