package com.lcwd.todo.Services;

import com.lcwd.todo.models.Todo;
import java.util.ArrayList;
import java.util.List;
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

}
