package com.lcwd.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.todo.Services.TodoService;
import com.lcwd.todo.models.Todo;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoService todoService;

    Random random = new Random();

    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo) {
        int id = random.nextInt(99999);
        todo.setId(id);

        Todo todo1 = TodoService.createTodo(todo);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }

    // get all todo
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodoHandler() {
        List<Todo> allTodos = todoService.getAllTodo();
        return new ResponseEntity<>(allTodos, HttpStatus.OK);
    }

    // getisngle todo
    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getSingleTodoHandler(@PathVariable int todoId) {
        Todo todo = todoService.getTodo(todoId);
        return ResponseEntity.ok(todo);
    }

    // update todo
    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodoHandler(@RequestBody Todo todoWithNewDetails, @PathVariable int todoId) {
        Todo todo = todoService.updateTodo(todoId, todoWithNewDetails);
        return ResponseEntity.ok(todo);
    }

    // delete
    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deleteTodo(@PathVariable int todoId) {
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("successfully delete");

    }

}
