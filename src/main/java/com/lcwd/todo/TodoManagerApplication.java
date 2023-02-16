package com.lcwd.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lcwd.todo.dao.TodoDao;
import com.lcwd.todo.models.Todo;

@SpringBootApplication

public class TodoManagerApplication implements CommandLineRunner {

	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}
	

	//todo 
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Todo todo = new Todo();
		todo.setId(123);
		todo.setTitle("testign jdbc");
		todo.setStatus("pending");
		todo.setAddedDate(new Date());
		todo.setTodoDate(new Date());

		TodoDao.saveTodo(todo);
	}

}
