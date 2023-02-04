package com.lcwd.todo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lcwd.todo.models.Todo;

@Component // kisi class ka object lifecycle jdbc smbhale uske lie ab hum iske object khi
           // use kr skte h
public class TodoDao {

    @Autowired // ye dependency h for this class to work
    private static JdbcTemplate template;

    public TodoDao(JdbcTemplate template) {
        TodoDao.template = template;

        // createing table if not exist
        String createTable = "create table IF NOT EXISTS todos(id int primary key, title varchar(100) not null, content varchar(4500), status varchar(10) not null, addedDate datetime, todoDate datetime)";
        template.update(createTable);
    }

    public static Todo saveTodo(Todo todo) {

        // columns
        String insertQuery = "insert into todos(id, title, content, status, addedDate, todoDate) values(?,?,?,?,?,?)";
        // dynamic query
        // unki values
        int rows = template.update(insertQuery, todo.getId(), todo.getTitle(), todo.getContent(), todo.getStatus(),
                todo.getAddedDate(), todo.getTodoDate());

        return todo;

    }
}
