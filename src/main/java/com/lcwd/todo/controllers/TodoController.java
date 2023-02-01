package com.lcwd.todo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.todo.Services.TodoService;
import com.lcwd.todo.models.Todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @PostMapping
    public Todo createTodoHandler(@RequestBody Todo todo) {

        logger.info("Create Todo");
        Todo todo1 = TodoService.createTodo(todo);
        return todo1;

    }

}
