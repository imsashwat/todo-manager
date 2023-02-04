package com.lcwd.todo.Services;

import com.lcwd.todo.models.Todo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class TodoService {

    Logger logger = LoggerFactory.getLogger(TodoService.class);

    static List<Todo> todos = new ArrayList<>();

    public static Todo createTodo(Todo todo) {

        todos.add(todo);
        // Logger.info("Todos {} ", this.todos);
        return todo;

    }

    public List<Todo> getAllTodo() {
        return todos;
    }

    public Todo getTodo(int todoId) {
        Todo todo = todos.stream().filter(t -> todoId == t.getId()).findAny().get();
        return todo;
    }

    public Todo updateTodo(int todoId, Todo todo) {
        List<Todo> newUpdateList = todos.stream().map(t -> {

            if (t.getId() == todoId) {
                // perform update
                t.setTitle(todo.getTitle());
                t.setContent(todo.getContent());
                t.setStatus(todo.getStatus());
                return t;

            } else {
                return t;
            }

        }).collect(Collectors.toList());

        todos = newUpdateList;
        todo.setId(todoId);
        return todo;
    }

    // method for delete
    public void deleteTodo(int todoId) {
        List<Todo> newList = todos.stream().filter(t -> t.getId() != todoId).collect(Collectors.toList());
        todos = newList;

    }

}
